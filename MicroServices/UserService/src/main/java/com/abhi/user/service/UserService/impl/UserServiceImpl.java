package com.abhi.user.service.UserService.impl;

import com.abhi.user.service.UserService.entities.Hotel;
import com.abhi.user.service.UserService.entities.Rating;
import com.abhi.user.service.UserService.entities.User;
import com.abhi.user.service.UserService.exceptions.ResourceNotFoundException;
import com.abhi.user.service.UserService.repositories.UserRepository;
import com.abhi.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByid(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by given id"));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/getAllByUser/"+user.getId(), Rating[].class);

        List<Rating> ratings = Arrays.asList(ratingsOfUser);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/getById/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

}
