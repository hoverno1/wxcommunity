package dn.controller;

import dn.domain.Post;
import dn.domain.Score;
import dn.service.RecommendService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    //基于用户推荐
    @RequestMapping("recommendByUser")
    public List<Post> recommendByUser(String aid, int number) throws TasteException, IOException {
        System.out.println(aid+"==="+number);
        List<Post> scores = recommendService.getRecommendByUser(aid, number);
//        System.out.println(scores);
        return scores;
    }

}
