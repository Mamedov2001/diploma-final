package kz.careerguidance.applicationapi.mapper;

import kz.careerguidance.applicationapi.dto.CreateUserDto;
import kz.careerguidance.applicationapi.dto.LoginDto;
import kz.careerguidance.applicationapi.dto.RegistrationDto;
import kz.careerguidance.applicationapi.dto.UserDto;
import kz.careerguidance.applicationapi.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserEntity user);

    UserEntity toUserEntity(UserDto userDto);

    UserEntity fromCreateUserDTOtoUserEntity(CreateUserDto createUserDto);

    LoginDto toLoginDto(RegistrationDto registrationDto);
}
