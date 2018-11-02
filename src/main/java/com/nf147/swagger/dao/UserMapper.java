package com.nf147.swagger.dao;

import com.nf147.swagger.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByUserName(String userName);

    int insert(User record);

    User selectByPrimaryKey(Integer id);
    User selectByUserName(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int Login(User user);


}