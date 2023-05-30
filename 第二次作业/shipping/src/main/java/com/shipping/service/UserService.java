package com.shipping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shipping.pojo.User;

/**
 * @author jianghan
 */
public interface UserService extends IService<User> {

    boolean addUser(User user);

    boolean selectUser(User user);

    boolean isValidUser(User user);
}
