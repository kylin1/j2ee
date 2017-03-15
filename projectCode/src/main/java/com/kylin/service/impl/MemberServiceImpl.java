package com.kylin.service.impl;

import com.kylin.model.Bankcard;
import com.kylin.model.Member;
import com.kylin.model.MemberOrder;
import com.kylin.repository.*;
import com.kylin.service.MemberService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.NumberHelper;
import com.kylin.tools.myenum.MemberLevel;
import com.kylin.tools.myenum.MemberOrderStatus;
import com.kylin.tools.myenum.MemberStatus;
import com.kylin.tools.myenum.RoomType;
import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.MemberOrderVO;
import com.kylin.vo.MemberUpdateTableVO;
import com.kylin.vo.SearchMemberVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomGuestRepository roomGuestRepository;

    @Autowired
    private BankcardRepository bankcardRepository;

    @Override
    public MemberInfoVO getMemberInfo(int memberId) {
        Member entity = this.repository.findOne(memberId);
        // get enums
        MemberStatus memberStatus = MemberStatus.getEnum(entity.getStatus());
        String strStatus = memberStatus.getStrStatus();

        MemberLevel memberLevel = MemberLevel.getEnum(entity.getLevel());

        Date expireTime = entity.getExpireTime();
        Date now = new Date();
        Date yearAgo = DateHelper.addDate(now, -365);

        // 有效期一年到期,过期时间 < 现在时间
        if (memberStatus == MemberStatus.Activated && expireTime.before(now)) {
            memberStatus = MemberStatus.Expired;

            // 如果过期了一年,则停止 : 过期的时间是现在时间的一年之前
        } else if (memberStatus == MemberStatus.Expired && expireTime.before(yearAgo)) {
            memberStatus = MemberStatus.Stopped;
        }

        // 更新数据库状态
        entity.setStatus(memberStatus.ordinal());
        this.repository.save(entity);

        // 获取七位数的编码
        String carNumber = NumberHelper.getSevenNumber(memberId);

        MemberInfoVO memberInfoVO = new MemberInfoVO(carNumber, memberId, entity.getName(),
                entity.getPhone(), entity.getBankCard(), entity.getEmail(), strStatus,
                entity.getActivatedTime(), entity.getExpireTime(),
                entity.getConsume(), entity.getBalance(), memberLevel, entity.getScore());

        return memberInfoVO;
    }

    @Override
    public MemberInfoVO getMemberInfoByUserId(int userId) {
        int memberId = this.repository.findMemberIdByUserId(userId);
        return this.getMemberInfo(memberId);
    }

    @Override
    public List<MemberOrderVO> getCurrentOrderList(int memberId) {
        List<MemberOrderVO> result = new ArrayList<>();
        // 当前订单包括预定的没入住的, 和已经入住的
        List<MemberOrderVO> reserved = this.getOrderList(memberId, MemberOrderStatus.Reserved);
        List<MemberOrderVO> checkedIn = this.getOrderList(memberId, MemberOrderStatus.CheckedIn);
        result.addAll(reserved);
        result.addAll(checkedIn);
        return result;
    }

    @Override
    public List<MemberOrderVO> getDoneOrderList(int memberId) {
        List<MemberOrderVO> result = new ArrayList<>();
        // 结束的订单包括 取消的, 已经离开点的
        List<MemberOrderVO> canceled = this.getOrderList(memberId, MemberOrderStatus.Canceled);
        List<MemberOrderVO> checkedOut = this.getOrderList(memberId, MemberOrderStatus.CheckedOut);
        result.addAll(canceled);
        result.addAll(checkedOut);
        return result;
    }

    /**
     * 获取用户指定状态的订单信息
     *
     * @param memberId    用户
     * @param orderStatus 订单状态
     * @return
     */
    public List<MemberOrderVO> getOrderList(int memberId, MemberOrderStatus orderStatus) {
        List<MemberOrderVO> result = new ArrayList<>();
        int statusInt = orderStatus.ordinal();
        List<MemberOrder> memberOrders = orderRepository.findByMemberIdAndStatus(memberId, statusInt);

        // every order
        for (MemberOrder order : memberOrders) {
            // basic info
            int hotelId = order.getHotelId();
            String hotelName = hotelRepository.findNameById(hotelId);
            int totalPrice = order.getPrice();

            // date
            Date orderDate = order.getOrderTime();
            Date checkInDate = order.getCheckIn();
            Date checkOutDate = order.getCheckOut();

            // 出行人
            List<String> customers = roomGuestRepository.findNameByOrderId(order.getId());

            MemberOrderVO vo = new MemberOrderVO(order.getId(), hotelName, orderDate, customers, checkInDate, checkOutDate,
                    totalPrice, orderStatus);
            result.add(vo);
        }

        return result;
    }

    @Override
    public List<SearchMemberVO> getOrderHistory(String member) throws NotFoundException {
        List<SearchMemberVO> result = new ArrayList<>();

        //查询到的所有用户
        List<Member> targetMembers = this.searchMember(member);
        if (targetMembers.isEmpty()) {
            throw new NotFoundException("输入的会员姓名不存在!");
        }

        // 找到用户
        for (Member targetMember : targetMembers) {
            // 对于每一个用户
            int memberId = targetMember.getId();
            List<MemberOrder> memberOrders = orderRepository.findByMemberId(memberId);
            // every order
            for (MemberOrder order : memberOrders) {
                // basic info
                int hotelId = order.getHotelId();
                String hotelName = hotelRepository.findNameById(hotelId);
                Date orderDate = order.getOrderTime();
                RoomType roomType = RoomType.getEnum(order.getRoomType());
                int number = order.getRoomNumber();
                int price = order.getPrice();

                // add to result
                SearchMemberVO vo = new SearchMemberVO(targetMember.getName(), orderDate, hotelName,
                        roomType, number, price);
                result.add(vo);
            }
        }

        return result;
    }

    private List<Member> searchMember(String member) {
        return this.repository.findByNameIgnoreCaseContaining(member);
    }

    @Override
    public MyMessage topUp(int memberId, int amount, int score) {
        Member member = this.repository.findOne(memberId);
        if (member == null)
            return new MyMessage(false, "会员不存在");

        // get member info
        final int oldBalance = member.getBalance();
        final int oldScore = member.getScore();
        final int oldStatusInt = member.getStatus();

        final MemberStatus oldStatus = MemberStatus.getEnum(oldStatusInt);


        if (oldScore < score)
            return new MyMessage(false, "积分不足,无法抵用.");

        // 根据充值情况改变状态,如果从未激活,充值 > 1000一次激活
        if (oldStatus == MemberStatus.NeverActivated) {
            if (amount > 1000) {
                this.recoverActivated(member);
                //未激活会员 升级到 低级会员
                System.out.println("member.setLevel");
                member.setLevel(MemberLevel.Low.ordinal());
            }
        } else if (oldStatus == MemberStatus.Expired) {
            // 费用不足被暂停, 一旦支付则恢复记录
            this.recoverActivated(member);
        }

        // 增加余额
        member.setBalance(oldBalance + amount);
        // 减去使用的积分
        member.setScore(oldScore - score);
        this.repository.save(member);

        //实际扣款金额是 金额-积分/100
        double amountToTake = amount - score / 100.0;
        // 银行卡扣款
        MyMessage myMessage = this.reduceBankCard(member.getBankCard(), amountToTake);
        if (!myMessage.isSuccess()) {
            return myMessage;
        }
        return new MyMessage(true, "充值" + amount + "元成功,从银行卡扣除" + amountToTake + "元");
    }

    private void recoverActivated(Member member) {

        MemberStatus newStatus = MemberStatus.Activated;
        //激活,有效期一年
        final Date oldExpireTime = member.getExpireTime();
        Date newExpireTime = DateHelper.addDate(oldExpireTime, 365);

        //更新状态
        member.setStatus(newStatus.ordinal());
        member.setExpireTime(newExpireTime);
    }

    private MyMessage reduceBankCard(String bankCard, double amountToTake) {
        Bankcard bankcard = this.bankcardRepository.findByCardNumber(bankCard);
        // 检查银行卡是否存在
        if (bankcard == null) {
            return new MyMessage(false, "银行卡:" + bankCard + "不存在");
        }
        // 银行卡存在,检察余额
        double balance = bankcard.getBalance();
        if (amountToTake > balance) {
            return new MyMessage(false, "银行卡余额不足! 当前余额:" + balance + ",需要扣除金额:" + amountToTake);
        }
        return new MyMessage(true);
    }

    @Override
    public MyMessage updateInfo(MemberUpdateTableVO updateVO) {
        Member member = this.repository.findOne(updateVO.getMemberId());
        if (member == null)
            return new MyMessage(false, "会员不存在");

        String cardNumber = updateVO.getBankCard();
        Bankcard bankcard = this.bankcardRepository.findByCardNumber(cardNumber);
        if (bankcard == null) {
            return new MyMessage(false, "银行卡号:" + cardNumber + " 不存在!");
        }

        member.setName(updateVO.getName());
        member.setBankCard(updateVO.getBankCard());
        member.setPhone(updateVO.getPhone());
        member.setEmail(updateVO.getEmail());

        this.repository.save(member);
        return new MyMessage(true, "用户信息更新成功");
    }

    @Override
    public MyMessage cancelMember(int memberId) {
        Member member = this.repository.findOne(memberId);
        member.setStatus(MemberStatus.Stopped.ordinal());
        member.setExpireTime(new Date());
        this.repository.save(member);

        return new MyMessage(true);
    }
}
