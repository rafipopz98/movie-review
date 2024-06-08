package dev.rafi.movie.listing.controllers;

import dev.rafi.movie.listing.models.Reviews;
import dev.rafi.movie.listing.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Review {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/addReview")
    public ResponseEntity<Reviews> addNewReview(@RequestBody Map<String,String> reviewbody){
        return new ResponseEntity<Reviews>(reviewService.addReview(reviewbody.get("body"),reviewbody.get("title")), HttpStatus.CREATED);
    }
}
