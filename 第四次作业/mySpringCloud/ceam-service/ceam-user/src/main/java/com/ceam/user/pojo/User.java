package com.ceam.user.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jianghan
 */
@TableName("user")
@Data
public class User {

    @TableId("id")
    private int id;

    private String passwords;

    private String name;


    public User(int id, String passwords) {
        this.id = id;
        this.passwords = passwords;
        this.name = "";
    }

    public User(int id, String passwords, String name) {
        this.id = id;
        this.passwords = passwords;
        this.name = name;
    }

    public User() {
    }

}
