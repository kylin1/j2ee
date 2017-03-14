package com.kylin.service.impl;

import com.kylin.model.Member;
import com.kylin.model.MemberOrder;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.MemberRepository;
import com.kylin.repository.OrderRepository;
import com.kylin.repository.RoomGuestRepository;
import com.kylin.service.MemberService;
import com.kylin.tools.DateHelper;
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

    @Override
    public MemberInfoVO getMemberInfo(int memberId) {
        Member entity = this.repository.findOne(memberId);
        // get enums
        MemberStatus memberStatus = MemberStatus.getEnum(entity.getStatus());
        MemberLevel memberLevel = MemberLevel.getEnum(entity.getLevel());

        Date expireTime = entity.getExpireTime();
        Date now = new Date();

        // 如果过时, 过期时间 < 现在时间
        if (expireTime.before(now)) {
            memberStatus = MemberStatus.Expired;
            // 更新数据库状态
            entity.setStatus(memberStatus.ordinal());
            this.repository.save(entity);
        }

        MemberInfoVO memberInfoVO = new MemberInfoVO(memberId, entity.getName(),
                entity.getPhone(), entity.getBankCard(), entity.getEmail(),memberStatus,
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
    public List<MemberOrderVO> getOrderList(int memberId) {
        List<MemberOrderVO> result = new ArrayList<>();
        List<MemberOrder> memberOrders = orderRepository.findByMemberId(memberId);

        // every order
        for (MemberOrder order : memberOrders) {
            // basic info
            int hotelId = order.getHotelId();
            String hotelName = hotelRepository.findNameById(hotelId);
            int totalPrice = order.getPrice();
            MemberOrderStatus orderStatus = MemberOrderStatus.getEnum(order.getStatus());

            // date
            Date orderDate = order.getOrderTime();
            Date checkInDate = order.getCheckIn();
            Date checkOutDate = order.getCheckOut();

            // 出行人
            List<String> customers = roomGuestRepository.findNameByOrderId(order.getId());

            MemberOrderVO vo = new MemberOrderVO(hotelName, orderDate, customers, checkInDate, checkOutDate,
                    totalPrice, orderStatus);
            result.add(vo);
        }

        return result;
    }

    @Override
    public List<SearchMemberVO> getOrderHistory(String member) throws NotFoundException {
        List<SearchMemberVO> result = new ArrayList<>();

        // 姓名/账号
        Member targetMember = this.searchMember(member);

        if(targetMember == null){
            throw new NotFoundException("输入的会员姓名/账号不存在!");
        }

        // 找到用户
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
            SearchMemberVO vo = new SearchMemberVO(orderDate, hotelName, roomType, number, price);
            result.add(vo);
        }
        return result;
    }

    private Member searchMember(String member) {
        List<Member> targetMember = this.repository.findByNameIgnoreCaseContaining(member);

        if(!targetMember.isEmpty()){
            return targetMember.get(0);
        }

        return null;
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
        final Date oldExpireTime = member.getExpireTime();

        MemberStatus newStatus;
        Date newExpireTime;

        if (oldScore < score)
            return new MyMessage(false, "积分不足,无法抵用");

        // 根据充值情况改变状态,如果从未激活,则充值一次激活
        // 如果过期,则重新激活同上
        if (oldStatus == MemberStatus.NeverActivated || oldStatus == MemberStatus.Expired) {
            newStatus = MemberStatus.Activated;
            //第一次激活,有效期一年
            newExpireTime = DateHelper.addDate(oldExpireTime, 365);

            //更新状态
            member.setStatus(newStatus.getStatus());
            member.setExpireTime(newExpireTime);
        } //否则状态本身就是激活,无需什么操作

        //实际扣款金额是 金额-积分/100
        double amountToTake = amount - score / 100.0;
        // 增加余额
        member.setBalance(oldBalance + amount);
        member.setScore(oldScore - score);

        this.repository.save(member);
        return new MyMessage(true, "充值" + amount + "元成功,从银行卡扣除" + amountToTake + "元");
    }

    @Override
    public MyMessage updateInfo(MemberUpdateTableVO updateVO) {
        Member member = this.repository.findOne(updateVO.getMemberId());
        if (member == null)
            return new MyMessage(false, "会员不存在");

        member.setName(updateVO.getName());
        member.setBankCard(updateVO.getBankCard());
        member.setPhone(updateVO.getPhone());
        member.setEmail(updateVO.getEmail());

        this.repository.save(member);
        return new MyMessage(true, "用户信息更新成功");
    }
}
