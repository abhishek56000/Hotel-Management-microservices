package com.abhi.hotel.hotelService.repositories;

import com.abhi.hotel.hotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
