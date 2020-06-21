package dn.service;

import dn.domain.Post;
import dn.domain.Score;

import java.util.List;

public interface RecommendService {
    List<Post> getRecommendByUser(String aid, int number);
}
