package com.nf147.swagger.dao;

import com.nf147.swagger.entity.Order;
import com.nf147.swagger.entity.User;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    Order select(String status);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    User selectByUserName(String userName);


}