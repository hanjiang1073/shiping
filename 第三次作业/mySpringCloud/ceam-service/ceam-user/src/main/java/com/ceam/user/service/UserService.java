package com.ceam.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.user.pojo.User;

/**
 * @author jianghan
 */
public interface UserService extends IService<User> {

    boolean addUser(User user);

    boolean selectUser(User user);

    boolean isValidUser(User user);
}
