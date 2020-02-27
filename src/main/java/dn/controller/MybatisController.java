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

    //获取检验前端返回的登陆信息
    @RequestMapping("/Test")
    @ResponseBody
    public int Test(String frontUsername,String frontPassword) {
        List<User> users = queryLogin();
        int flag = 0;
        //遍历users,查找是否有此用户
        for(User user:users){
            if(frontUsername.equals(user.getAuthor())&&frontPassword.equals(user.getPassword())){
                //有就改变status状态，返回确认信息
                user.setStatus(1);
                //1就是flag的值
                return 1;
            }
        }
        //无就返回否定信息
        //信息名为flag 1：有此用户信息 0：无此用户信息
        return flag;
    }
}
