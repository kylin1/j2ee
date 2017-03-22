package com.kylin.service.impl;

import com.kylin.model.Hotel;
import com.kylin.model.Member;
import com.kylin.model.SystemUser;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.MemberRepository;
import com.kylin.repository.SystemUserRepository;
import com.kylin.service.SystemUserService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.MemberLevel;
import com.kylin.tools.myenum.MemberStatus;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    protected SystemUserRepository repository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private MemberRepository memberRepository;

    private String emptyString = "暂未设置";
    private Date yearAgo = DateHelper.addDate(new Date(),-365);
    private Date today = DateHelper.NOW;
    private Date yearAfter = DateHelper.addDate(new Date(),365);

    @Override
    public LoginResultVO login(String account, String password)  {
        //根据邮箱信息查询用户
        SystemUser user = repository.findByAccount(account);
        //查询不到用户
        if(user == null){
            return new LoginResultVO(false,"用户不存在!");
        }

        // 查询到了用户,下面检查类型
        int intType = user.getType();
        SystemUserType systemUserType = SystemUserType.getType(intType);

        //密码正确
        if (user.getPassword().equals(password)) {
            return new LoginResultVO(true, user.getId(), systemUserType);

        //密码错误
        } else {
            return new LoginResultVO(false,"密码错误!");
        }
    }

    @Override
    public MyMessage signUp(String account, String password, SystemUserType userType) {
        SystemUser user = repository.findByAccount(account);
        //查询不到用户
        if (user == null) {
            // 创建系统用户
            SystemUser systemUser = new SystemUser();
            systemUser.setAccount(account);
            systemUser.setPassword(password);
            systemUser.setType(userType.getType());
            this.repository.save(systemUser);

            int systemUserId = systemUser.getId();
            System.out.println("sign up new systemUserId = "+systemUserId);
            MyMessage myMessage = new MyMessage(true);
            myMessage.setData(systemUserId);

            //创建对应类型的实体
            this.saveEntity(systemUserId,userType);

            return myMessage;
        } else
            return new MyMessage(false, "账户已经存在");
    }

    private void saveEntity(int systemUserId, SystemUserType userType) {

        if(userType == SystemUserType.Guest){
            Member member = new Member();
            member.setUserId(systemUserId);

            member.setName(this.emptyString);
            member.setPhone(this.emptyString);
            member.setEmail(this.emptyString);
            member.setStatus(MemberStatus.NeverActivated.ordinal());

            member.setBankCard(this.emptyString);
            // 从未激活
            member.setActivatedTime(this.yearAgo);
            member.setExpireTime(this.yearAgo);

            member.setConsume(0);
            member.setBalance(0);
            member.setLevel(MemberLevel.None.ordinal());
            member.setScore(0);

            this.memberRepository.save(member);

        }else if(userType == SystemUserType.Hotel){
            Hotel hotel = new Hotel();

            hotel.setName(this.emptyString);
            hotel.setLocation(this.emptyString);
            hotel.setLevel(HotelLevel.ChainHotel.ordinal());
            hotel.setUserId(systemUserId);

            hotel.setPhone(this.emptyString);
            hotel.setRepresentative(this.emptyString);

            this.hotelRepository.save(hotel);

            // 经理
        }else {

        }

    }
}
