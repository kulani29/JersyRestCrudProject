package com.example.controller;


import com.example.dao.UserRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/api/v1")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces("application/json")
    @Path("/users")
    public List<User> getAllUsers() {

        System.out.println("Call received to get all users");
        return userRepository.findAll();
    }

    @GET
    @Produces("application/json")
    @Path("/users/get/{id}")
    public ResponseEntity<User> getUserById(@PathParam(value = "id") Long userId) throws ResourceNotFoundException {
        System.out.println("User id received is :"+userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path(value = "/users")
    public User createUser(User user) {

        System.out.println("Call received to insert user");
        return userRepository.save(user);
    }


}
