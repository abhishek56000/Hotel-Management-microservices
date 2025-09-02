package com.abhi.rating.ratingService.services;

import com.abhi.rating.ratingService.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating save(Rating rating);

    public List<Rating> getAllRatings();

    public List<Rating> getAllbyUserId(int userId);

    public List<Rating> getAllByHotelId(int hotelId);
}
