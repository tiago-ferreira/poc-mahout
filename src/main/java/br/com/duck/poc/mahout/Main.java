package br.com.duck.poc.mahout;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class Main {

  public static void main(String[] args) throws IOException, TasteException {

    DataModel model = new LoadModel().getCoursesModel();
    Recommender recommender = new RecommenderItemsBuilder().buildRecommender(model);
    
    List<RecommendedItem> recommendations = recommender.recommend(2, 3);
    
    for (RecommendedItem item : recommendations) {
      System.out.println(item);
    }
    
  }

}