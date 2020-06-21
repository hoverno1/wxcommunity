package dn.service;

import dn.domain.Post;
import dn.domain.Score;
import dn.mapper.UserMapper;
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
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataModel dataModel;

    @Override
    public List<Post> getRecommendByUser(String aid, int number) {
        List<Post> list = null;
        //读取数据库失败，选用读取csv文件的方法
//        try {
//            // 相似度计算（皮尔森相似度）
//            PearsonCorrelationSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
//            // 设置相似用户阈值（或使用NearestNUserNeighborhood）
//            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(100, similarity, dataModel);
//            // 基于以上数据创建推荐器（这里使用的是基于用户的推荐，还有GenericItemBasedRecommender等推荐器）
//            Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
//            long l = Long.parseLong(aid);
//            //System.out.println("l:"+aid);
//            List<RecommendedItem> recommendItemList = recommender.recommend(l, number);
//            List<String> itemIds = new ArrayList<String>();
//            for (RecommendedItem recommendedItem : recommendItemList) {
//                System.out.println(recommendedItem);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try {
            DataModel model = new FileDataModel(new File("C:\\Users\\Administrator\\Desktop\\dataset.csv"));
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            long longAid = Long.parseLong(aid);
            List<RecommendedItem> recommendedItemList = recommender.recommend(2, 4);
            List<Long> itemIds = new ArrayList<>();
            for (RecommendedItem recommendedItem : recommendedItemList) {
                System.out.println(recommendedItem);
                itemIds.add(recommendedItem.getItemID());
            }
            System.out.println("推荐出来的id集合"+itemIds);

            //根据id查询
            if(itemIds!=null&&itemIds.size()>0){
                list =userMapper.findAllByAid(itemIds);
            }else{
                list=new ArrayList<>();
            }
            System.out.println("推荐数量："+list.size());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TasteException e) {
            e.printStackTrace();
        }
        return list;
    }
}
