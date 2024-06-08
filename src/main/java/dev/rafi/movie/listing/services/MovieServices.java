package dev.rafi.movie.listing.services;

import dev.rafi.movie.listing.models.MoviesModels;
import dev.rafi.movie.listing.repos.MoviesRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {

    @Autowired
    private MoviesRepo moviesRepo;

    public List<MoviesModels> allMovies(){
        return moviesRepo.findAll();
    }

    public Optional<MoviesModels> singleMovie(ObjectId id){
        return moviesRepo.findById(id);
    }

    public Optional<MoviesModels> singleMovieByTitle(String title){
        return moviesRepo.findMovieByTitle(title);
    }

    public MoviesModels newMovie(MoviesModels movie){
        return moviesRepo.save(movie);
    }
}
