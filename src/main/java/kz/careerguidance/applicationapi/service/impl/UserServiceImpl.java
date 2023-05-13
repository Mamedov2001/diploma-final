package kz.careerguidance.applicationapi.service.impl;

import kz.careerguidance.applicationapi.dto.CreateUserDto;
import kz.careerguidance.applicationapi.dto.UserDto;
import kz.careerguidance.applicationapi.entity.History;
import kz.careerguidance.applicationapi.entity.UserEntity;
import kz.careerguidance.applicationapi.exceptions.NotFoundException;
import kz.careerguidance.applicationapi.exceptions.NotUniqueUsernameException;
import kz.careerguidance.applicationapi.mapper.UserMapper;
import kz.careerguidance.applicationapi.repository.UserRepository;
import kz.careerguidance.applicationapi.repository.university.HistoryRepository;
import kz.careerguidance.applicationapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  private final HistoryRepository historyRepository;
  private final UserMapper userMapper;


  public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
                         HistoryRepository historyRepository, UserMapper userMapper) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
    this.historyRepository = historyRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto findByUsername(String username) {
    return userRepository.findByUsername(username)
        .map(userMapper::toUserDto)
        .orElseThrow(() -> new NoSuchElementException("User not found by username: " + username));
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserDto create(CreateUserDto createUserDto) {
    Optional<UserEntity> user = userRepository.findByUsername(createUserDto.getUsername());
    if (user.isPresent()) {
      throw new NotUniqueUsernameException("User with username " + createUserDto.getUsername() + " already exists");
    }

    Optional<UserEntity> userEmail = userRepository.findByEmail(createUserDto.getEmail());
    if (userEmail.isPresent()) {
      throw new NotUniqueUsernameException("User with email " + createUserDto.getEmail() + " already exists");
    }


    if (createUserDto.getPassword() == null) {
      throw new IllegalArgumentException();
    }
    createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
    return userMapper.toUserDto(userRepository
        .save(userMapper
            .fromCreateUserDTOtoUserEntity(createUserDto)));
  }

  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
  }

  @Override
  @Transactional
  public UserDto update(Long id, UserDto userDto) {
    UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));

    if (null != userDto.getUsername()) {
      user.setUsername(userDto.getUsername());
    }

    if (null != userDto.getEmail()) {
      user.setEmail(userDto.getEmail());
    }

    if (null != userDto.getPassword()) {
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

    if (null != userDto.getRole()) {
      user.setRole(userDto.getRole());
    }

    if (null != userDto.getHistory()) {
      userDto.getHistory().forEach(x->{
        History history = historyRepository.findById(x.getId())
                .orElseThrow(() -> new NotFoundException("History with id " + x.getId() + " not found"));
          history.setUser(user);
          historyRepository.save(history);
      });

    }

    if (null != userDto.getLocation()) {
      user.setLocation(userDto.getLocation());
    }

    return userMapper.toUserDto(userRepository.save(user));
  }

  @Override
  public UserDto findById(Long id) {
    return userMapper.toUserDto(userRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("Пользователь с id " + id + " не найден")));
  }
}
