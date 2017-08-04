package br.com.duck.poc.mahout;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliator {

  public static void main(String[] args) throws IOException, TasteException {
    
    RandomUtils.useTestSeed();
    DataModel model = new LoadModel().getCoursesModel();
    RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
    RecommenderBuilder recommender = new RecommenderItemsBuilder();
    double error = evaluator.evaluate(recommender, null, model, 0.9, 0.1);
    System.out.println(error);

  }
}
