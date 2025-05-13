package com.codtech.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecommendationSystem {

    public static void main(String[] args) {
        try {
            // Load data from file
            File file = new File("data.csv");
            DataModel model = new FileDataModel(file);

            // Compute similarity
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);

            // Recommender engine
            Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
            List<RecommendedItem> recommendations = recommender.recommend(3,5);
            System.out.println(recommendations.size());
            System.out.println(similarity.userSimilarity(1, 2));

           if (recommendations.isEmpty()) {
            System.out.println("No recommendations available for this user.");
        } else {
            System.out.println("Recommendations for User 3:");
            for (RecommendedItem item : recommendations) {
                System.out.println("Product ID: " + item.getItemID() + " | Estimated Rating: " + item.getValue());
            }
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

