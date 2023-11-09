package com.ar.cac.PracticaCAC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.cac.PracticaCAC.entities.User;
import com.ar.cac.PracticaCAC.entities.dtos.UserDto;
import com.ar.cac.PracticaCAC.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

  private UserService userService;
   
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.status(200).body(userService.getAllUsers());
  }

  @GetMapping(value = "/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return ResponseEntity.status(200).body(userService.getUserById(id));
  }

  @PostMapping(value = "/users")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    return ResponseEntity.status(201).body(userService.createUser(userDto));
  }

  //TODO: update
  


  //TODO: delete


}
