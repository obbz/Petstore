package com.nf147.swagger.controller;

import com.nf147.swagger.dao.OrderMapper;
import com.nf147.swagger.entity.Order;
import com.nf147.swagger.vo.aaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class storeContrller {

    @Autowired
    OrderMapper orderMapper;
    @GetMapping
    @ResponseBody
    public aaa inventory(){
        if(orderMapper.select("inventory") != null){
            return new aaa(200, "success", "successful operation");
        }
        return new aaa();
    }


    @PostMapping
    @ResponseBody
    public aaa add(Order order){
        if(orderMapper.insert(order) != 0){
            return new aaa(200, "success", "successful operation");
        }else {
            return new aaa(400, "error", "Invalid Order");
        }
    }

    @GetMapping
    @ResponseBody
    public aaa OrderId(@PathVariable int orderId){
        if(orderId == 0){
            return new aaa(400, "error", "Invalid Order");
        }else {
            if(orderMapper.deleteByPrimaryKey(orderId) != 0){
                return new aaa(200, "success", "successful operation");
            }else {
                return new aaa(400, "error", "Invalid Order");
            }
        }
    }

    @GetMapping
    @ResponseBody
    public aaa deId(@PathVariable int orderId){
        if(orderId == 0){
            return new aaa(400, "error", "Invalid Order");
        }else {
            if(orderMapper.deleteByPrimaryKey(orderId) != 0){
                return new aaa(200, "success", "successful operation");
            }else {
                return new aaa(400, "error", "Invalid Order");
            }
        }
    }
}
