package com.abhi.rating.ratingService.repositories;

import com.abhi.rating.ratingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    public List<Rating> findByUserId(int userId);

    public List<Rating> findByHotelId(int hotelId);
}
