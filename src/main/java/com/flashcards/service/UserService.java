package com.flashcards.service;

import com.flashcards.domain.User;
import com.flashcards.domain.dto.UserDto;
import com.flashcards.mapper.UserMapper;
import com.flashcards.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers(){
        return userMapper.mapToUserDtoList(userRepository.findAll());
    }

    public UserDto getUserById(final Long userId) throws RuntimeException {
        return userMapper.mapToUserDto(userRepository.findById(userId).orElseThrow(() -> new RuntimeException()));
    }

    public User saveUser(final UserDto userDto){
        return userRepository.save(userMapper.mapToUser(userDto));
    }

    public void deleteUser(final Long aLong){
        userRepository.deleteById(aLong);
    }
}
