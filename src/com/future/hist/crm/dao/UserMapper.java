package com.future.hist.crm.dao;

import com.future.hist.crm.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int count();
    
    int deleteByUser(User user);

    int deleteById(long id);

    int add(User user);

    int addSelective(User user);

    List<User> selectByUser(User user);

    User selectById(long id);

    int updateByUserSelective(@Param("user") User user);

    int updateByUser(@Param("user") User user);

    int updateByIdSelective(User user);

    int updateById(User user);
}