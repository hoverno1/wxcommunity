package dn.controller;

import dn.domain.Post;
import dn.domain.User;
import dn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    //获取user_login表中数据
    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryLogin() {
        List<User> users = userMapper.queryUserList();
        return users;
    }

    //获取author_post表中数据
    @RequestMapping("/queryPost")
    @ResponseBody
    public List<Post> queryPost() {
        List<Post> posts = userMapper.queryPostList();
        return posts;
    }
}
