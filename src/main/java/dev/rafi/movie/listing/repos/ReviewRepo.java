package dev.rafi.movie.listing.repos;

import dev.rafi.movie.listing.models.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Reviews, ObjectId> {
}
