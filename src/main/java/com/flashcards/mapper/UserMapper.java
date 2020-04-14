package com.flashcards.mapper;

import com.flashcards.domain.User;
import com.flashcards.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getLanguage(),
                userDto.getUserAppColor(),
                new ArrayList<>()
        );
    }
    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getLanguage(),
                user.getUserAppColor(),
                new ArrayList<>()
        );
    }
    public List<UserDto> mapToUserDtoList(final List<User> userList){
        return userList.stream()
                .map(u -> new UserDto(u.getId(),u.getName(),u.getPassword(), u.getEmail(),u.getLanguage(),u.getUserAppColor(),new ArrayList<>()))
                .collect(Collectors.toList());
    }

}

