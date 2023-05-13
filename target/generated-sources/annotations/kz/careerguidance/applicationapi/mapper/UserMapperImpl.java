package kz.careerguidance.applicationapi.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import kz.careerguidance.applicationapi.dto.CreateUserDto;
import kz.careerguidance.applicationapi.dto.LoginDto;
import kz.careerguidance.applicationapi.dto.RegistrationDto;
import kz.careerguidance.applicationapi.dto.UserDto;
import kz.careerguidance.applicationapi.entity.History;
import kz.careerguidance.applicationapi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T15:44:15+0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setRole( user.getRole() );
        userDto.setLocation( user.getLocation() );
        List<History> list = user.getHistory();
        if ( list != null ) {
            userDto.setHistory( new ArrayList<History>( list ) );
        }

        return userDto;
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( userDto.getId() );
        userEntity.username( userDto.getUsername() );
        userEntity.email( userDto.getEmail() );
        userEntity.password( userDto.getPassword() );
        userEntity.role( userDto.getRole() );
        userEntity.location( userDto.getLocation() );
        List<History> list = userDto.getHistory();
        if ( list != null ) {
            userEntity.history( new ArrayList<History>( list ) );
        }

        return userEntity.build();
    }

    @Override
    public UserEntity fromCreateUserDTOtoUserEntity(CreateUserDto createUserDto) {
        if ( createUserDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.username( createUserDto.getUsername() );
        userEntity.email( createUserDto.getEmail() );
        userEntity.password( createUserDto.getPassword() );
        userEntity.role( createUserDto.getRole() );
        userEntity.location( createUserDto.getLocation() );
        Set<History> set = createUserDto.getHistory();
        if ( set != null ) {
            userEntity.history( new ArrayList<History>( set ) );
        }

        return userEntity.build();
    }

    @Override
    public LoginDto toLoginDto(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }

        LoginDto loginDto = new LoginDto();

        loginDto.setUsername( registrationDto.getUsername() );
        loginDto.setPassword( registrationDto.getPassword() );

        return loginDto;
    }
}
