package kz.careerguidance.applicationapi.service;


import kz.careerguidance.applicationapi.dto.CreateUserDto;
import kz.careerguidance.applicationapi.dto.UserDto;

import java.util.List;

public interface UserService {
  UserDto findByUsername(String username);
  void delete(Long id);
  UserDto create(CreateUserDto createUserDto);
  List<UserDto> findAll();
  UserDto update(Long id, UserDto userDto);
  UserDto findById(Long id);
}
