package com.ar.cac.PracticaCAC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  // @Autowired
  // Autowired no es requerido en este caso, ya que se está usando un constructor
  // para inyectar la dependencia
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(value = "/users/{id}")
  public User getUserById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @PostMapping(value = "/users")
  public UserDto createUser(UserDto userDto) {
    return userService.createUser(userDto);
  }

}
