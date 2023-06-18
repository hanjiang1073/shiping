package com.ceam.user.controller;


import com.ceam.user.config.myJwt.JwtUtils;
import com.ceam.user.pojo.User;
import com.ceam.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghan
 */
@RestController
@RequestMapping("/User")
public class UserController {


    @Resource
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> logIn (@RequestBody User user) throws ParseException {






        Map<String, Object> chaim = new HashMap<>();
        String userid = String.valueOf(user.getId());

        chaim.put("userid", user.getId());
        if(userService.isValidUser(user)){
            String jwtToken = JwtUtils.generateToken(userid);
            chaim.put("token", jwtToken);
            chaim.put("msg", "登录成功");
        }
        else {
            chaim.put("msg", "登录失败");
        }

        return ResponseEntity.ok(chaim);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register (@RequestBody User user) throws ParseException{

        Map<String, Object> chaim = new HashMap<>();
        String userid = String.valueOf(user.getId());

        chaim.put("userid", user.getId());
        if(userService.addUser(user)){
            String jwtToken = JwtUtils.generateToken(userid);
            chaim.put("token", jwtToken);
            chaim.put("msg", "注册成功");
        }
        else {
            chaim.put("msg", "注册失败");
        }
        return ResponseEntity.ok(chaim);
    }
}
