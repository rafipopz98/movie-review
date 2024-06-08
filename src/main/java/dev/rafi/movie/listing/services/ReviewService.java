package dev.rafi.movie.listing.services;

import dev.rafi.movie.listing.models.MoviesModels;
import dev.rafi.movie.listing.models.Reviews;
import dev.rafi.movie.listing.repos.MoviesRepo;
import dev.rafi.movie.listing.repos.ReviewRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
  private  ReviewRepo reviewRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews addReview(String body, String title){
        Reviews review = reviewRepo.insert(new Reviews(body));
        mongoTemplate.update(MoviesModels.class).matching(Criteria.where("title").is(title)).apply(new Update().push("reviewIds").value(review)).first();
        return review;
    }
}
