package com.ar.cac.PracticaCAC.mappers;

import com.ar.cac.PracticaCAC.entities.User;
import com.ar.cac.PracticaCAC.entities.dtos.UserDto;

public class UserMappers {

  // Dto = Data Transfer Object
  // Mappers = Clase que se encarga de mapear un objeto a otro
  // En este caso, mapea un UserDto a un User
  public User userDtoToUser(UserDto dto) {
    User user = new User();
    user.setUsername(dto.getUsername());
    user.setPassword(dto.getPassword());
    return user;
  }

  public UserDto userToUserDto(User user) {
    UserDto dto = new UserDto();
    dto.setUsername(user.getUsername());
    dto.setPassword(user.getPassword());
    return dto;
  }
  
}
