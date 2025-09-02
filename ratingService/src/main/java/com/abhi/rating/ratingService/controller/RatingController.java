package com.abhi.rating.ratingService.controller;

import com.abhi.rating.ratingService.entities.Rating;
import com.abhi.rating.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<Rating> save(@RequestBody Rating rating){
        Rating rating1 = ratingService.save(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = ratingService.getAllRatings();

        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/getAllByUser/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable int userId){
        List<Rating> allRatingsByUser = ratingService.getAllbyUserId(userId);
        return ResponseEntity.ok(allRatingsByUser);
    }

    @GetMapping("/getAllByHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable int hotelId) {
        List<Rating> allRatingsByHotel = ratingService.getAllByHotelId(hotelId);
        return ResponseEntity.ok(allRatingsByHotel);
    }
}
