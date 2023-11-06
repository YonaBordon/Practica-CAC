package com.ar.cac.PracticaCAC.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.cac.PracticaCAC.entities.User;
import com.ar.cac.PracticaCAC.entities.dtos.UserDto;
import com.ar.cac.PracticaCAC.repositories.UserRepository;

@Service
public class UserService {

  // @Autowired
  // Autowired no es requerido en este caso, ya que se está usando un constructor
  // para inyectar la dependencia
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  // UserDto es un Usuario con solo usuario y contraseña
  // User es un Usuario con usuario, contraseña y mas informacion
  public UserDto createUser(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    userRepository.save(user);
    return userDto;
  }

  

}