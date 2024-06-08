package dev.rafi.movie.listing.repos;

import dev.rafi.movie.listing.models.MoviesModels;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepo extends MongoRepository<MoviesModels, ObjectId> {
    Optional<MoviesModels> findMovieByTitle(String title);
}
