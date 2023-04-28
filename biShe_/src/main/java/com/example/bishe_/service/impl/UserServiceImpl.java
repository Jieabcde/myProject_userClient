package com.example.bishe_.service.impl;

import com.example.bishe_.entity.User;
import com.example.bishe_.mapper.UserMapper;
import com.example.bishe_.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe_.util.JwtUtils;
import com.example.bishe_.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void createUser(User user) {
        User one = lambdaQuery().eq(User::getUemail, user.getUemail()).one();
        if (one != null) {
            throw new RuntimeException("此账户已注册，请重新注册");
        }
        user.setLid(1);
        user.setNowpoint(BigDecimal.ZERO);
        user.setHispoint(BigDecimal.ZERO);
        user.setImage("1.webp");
        user.setStatus(0);
        save(user);
    }

    @Override
    public UserModel login(UserModel userModel) {
        String uemail = userModel.getUemail();
        String upwd = userModel.getUpwd();

        //邮箱是否存在
        User user = lambdaQuery().eq(User::getUemail, uemail).one();
        if (user == null) {
            throw new RuntimeException("邮箱不存在");
        }

        //密码是否正确
        if (!user.getUpwd().equals(upwd)) {
            throw new RuntimeException("密码不正确");
        }

        //是否被封禁
        if (user.getStatus() == 1) {
            throw new RuntimeException("该账户被封禁");
        }

        //生成token
        String token = JwtUtils.createToken(user.getUid(), user.getUname());

        //组装信息
        UserModel userModel1 = new UserModel();
        BeanUtils.copyProperties(user, userModel1);
        userModel1.setToken(token);

        return userModel1;

    }

    @Override
    public List<User> getUserInfo(List<Integer> uidList) {
        return lambdaQuery().in(User::getUid, uidList).list();
    }

    @Override
    public void updateInfo(UserModel userModel) {
        lambdaUpdate().eq(User::getUid, userModel.getUid())
                .set(userModel.getUname() != null, User::getUname, userModel.getUname())
                .set(userModel.getUtel() != null, User::getUtel, userModel.getUtel())
                .set(userModel.getUemail() != null, User::getUemail, userModel.getUemail())
                .update();
    }

    @Override
    public void updatePwd(UserModel userModel) {
        //先匹配老密码是否正确
        User user = lambdaQuery().eq(User::getUid, userModel.getUid()).one();
        boolean equals = user.getUpwd().equals(userModel.getLastpwd());
        if (!equals) {
            throw new RuntimeException("老密码错误");
        }

        lambdaUpdate().eq(User::getUid, userModel.getUid())
                .set(User::getUpwd, userModel.getUpwd())
                .update();
    }

    @Override
    public void addPoint(BigDecimal oprice, Integer uid) {
        User user = this.getById(uid);
        user.setNowpoint(oprice.add(user.getNowpoint()));
        user.setHispoint(oprice.add(user.getHispoint()));
        this.updateById(user);
    }
}
