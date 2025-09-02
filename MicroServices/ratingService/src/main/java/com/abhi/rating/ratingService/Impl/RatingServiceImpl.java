package com.abhi.rating.ratingService.Impl;

import com.abhi.rating.ratingService.entities.Rating;
import com.abhi.rating.ratingService.repositories.RatingRepository;
import com.abhi.rating.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public Rating save(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllbyUserId(int userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllByHotelId(int hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
