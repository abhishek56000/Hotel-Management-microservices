package com.abhi.hotel.hotelService.controller;

import com.abhi.hotel.hotelService.entities.Hotel;
import com.abhi.hotel.hotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id){
        Hotel hotel =  hotelService.getHotelbyId(id);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }

}
