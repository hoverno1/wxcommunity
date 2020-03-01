package dn.mapper;

import dn.domain.Post;
import dn.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> queryUserList();

    public List<Post> queryPostList();

    public void insertUser(User user);
}