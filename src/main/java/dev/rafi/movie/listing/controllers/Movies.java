package dev.rafi.movie.listing.controllers;

import dev.rafi.movie.listing.models.MoviesModels;
import dev.rafi.movie.listing.services.MovieServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Movies {

    @Autowired
    private MovieServices movieServices;

    //get all movies
    @GetMapping(value = "/allMovies")
    public ResponseEntity<List<MoviesModels>> getAllMovies(){
        return new ResponseEntity<List<MoviesModels>>(movieServices.allMovies(), HttpStatus.OK);
    }

    // get one movie by id
    @GetMapping(value = "/movieId/{id}")
    public ResponseEntity<Optional<MoviesModels>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<MoviesModels>>(movieServices.singleMovie(id),HttpStatus.OK);
    }

    // get one movie by title
    @GetMapping(value = "/movie/{title}")
    public ResponseEntity<Optional<MoviesModels>> getSingleMovieByTitle(@PathVariable String title){
        return new ResponseEntity<Optional<MoviesModels>>(movieServices.singleMovieByTitle(title),HttpStatus.OK);
    }

    //add movie
    @PostMapping(value = "/movie/addNew")
    public MoviesModels addNew(@RequestBody MoviesModels movie){
        return movieServices.newMovie(movie);
    }
}
