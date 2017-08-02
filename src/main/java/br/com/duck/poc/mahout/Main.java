package br.com.duck.poc.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class Main {

  public static void main(String[] args) throws IOException, TasteException {

    DataModel model = new FileDataModel(new Main().getFile());
    UserSimilarity similarity =  new PearsonCorrelationSimilarity(model);
    UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
    
    UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
    
    List<RecommendedItem> recommendations = recommender.recommend(2, 3);
    
    for (RecommendedItem item : recommendations) {
      System.out.println(item);
    }
    
  }
  
  private File getFile() {
    ClassLoader classloader = getClass().getClassLoader();
    return new File(classloader.getResource("dados.csv").getFile());
  }

}