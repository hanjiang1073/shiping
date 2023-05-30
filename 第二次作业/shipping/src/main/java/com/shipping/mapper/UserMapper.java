package com.shipping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shipping.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jianghan
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
