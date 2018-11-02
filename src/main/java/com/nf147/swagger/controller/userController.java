package com.nf147.swagger.controller;

import com.nf147.swagger.dao.UserMapper;
import com.nf147.swagger.entity.User;
import com.nf147.swagger.vo.aaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class userController {
    @Autowired
    UserMapper userMapper;
    @PostMapping
    @ResponseBody
    public aaa addUser(User user) {
        if (userMapper.insert(user) != 0) {
            return new aaa("default", "successful operation");
        }
        return new aaa();
    }

    @PostMapping("/createWithArray")
    @ResponseBody
    public aaa addUser(ArrayList<User> list) {
        for (User user : list) {
            userMapper.insert(user);
        }
        return new aaa("default", "successful operation");
    }

    @PostMapping("/createWithList")
    @ResponseBody
    public aaa addUser(List<User> list) {
        for (User user : list) {
            userMapper.insert(user);
        }
        return new aaa("default", "successful operation");
    }

    @GetMapping("/login")
    @ResponseBody
    public aaa login(User user) {
        if (userMapper.Login(user) != 0) {
            userMapper.updateByPrimaryKey(user);
            return new aaa(200, "", "successful operation");
        } else {
            return new aaa(400, "", "Invalid username/password supplied");
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public aaa logout(@SessionAttribute User user) {
        userMapper.updateByPrimaryKey(user);
        return new aaa("default", "successful operation");
    }

    @GetMapping("/{username}")
    @ResponseBody
    public aaa findByUserName(@PathVariable String userName) {
        if (userName == "") {
            return new aaa(400, "", "Invalid username supplied");
        } else {
            if (userMapper.selectByUserName(userName) != null) {
                return new aaa(200, "", "successful operation");
            } else {
                return new aaa(404, "", "User not found");
            }
        }
    }

    @PutMapping("/{username}")
    @ResponseBody
    public aaa updateUser(@PathVariable String userName) {
        if (userName == "") {
            return new aaa(400, "", "Invalid username supplied");
        } else {
            User user = userMapper.selectByUserName(userName);
            if (user != null) {
                userMapper.updateByPrimaryKey(user);
            } else {
                return new aaa(404, "", "User not found");
            }
        }
        return new aaa();
    }

    @DeleteMapping("/{username}")
    @ResponseBody
    public aaa deleteUser(@PathVariable String userName){
        if (userName == "") {
            return new aaa(400, "", "Invalid username supplied");
        } else {
            User user = userMapper.selectByUserName(userName);
            if (user != null) {
                userMapper.deleteByUserName(userName);
            } else {
                return new aaa(404, "", "User not found");
            }
        }
        return new aaa();
    }
}
