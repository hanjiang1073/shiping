package com.ceam.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceam.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jianghan
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
