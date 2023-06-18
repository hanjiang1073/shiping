package com.ceam.user.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.user.service.UserService;
import com.ceam.user.mapper.UserMapper;
import com.ceam.user.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        if(selectUser(user)){
            return false;
        }
        userMapper.insert(user);
       // System.out.println(userMapper.insert(user));
        return true;
    }

    @Override
    public boolean selectUser(User user) {
        User temp = userMapper.selectById(user.getId());

        System.out.println(temp);

        return temp!= null;
    }

    @Override
    public boolean isValidUser(User user) {
        User temp = userMapper.selectById(user.getId());
        if(temp!= null){
            if(temp.getPasswords().equals(user.getPasswords())){
                return true;
            }
        }
        return false;
    }

}
