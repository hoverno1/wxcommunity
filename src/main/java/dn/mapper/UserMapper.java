package dn.mapper;

import dn.domain.Message;
import dn.domain.Post;
import dn.domain.Score;
import dn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> queryUserList();

    public List<Post> queryPostList();

    public void insertUser(User user);

    public User queryAid(String username);

    public void insertAvatar(User user);

    public User queryAvatar(String aid);

    public void insertPost(Post post);

    public int testName(String username);

    public void insertMessage(Message message);

    public List<Message> queryMessageList(String postId);

    public void addScore(@Param("scoreId") String aid, @Param("postId") String postId);

    public String queryAidByName(String author);

    public void testScore(@Param("scoreId") String aid, @Param("postId") String postId);

    public List<Post> findAllByAid(@Param("postIds") List<Long> postId);
}