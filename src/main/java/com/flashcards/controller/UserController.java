package com.flashcards.controller;

import com.flashcards.domain.dto.UserDto;
import com.flashcards.mapper.UserMapper;
import com.flashcards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "getUser")
    public UserDto getUsersById(@RequestParam long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "addUser")
    public void addUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @PutMapping(value = "updateUser")
    public void updateUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam long userId){
        userService.deleteUser(userId);
    }

}

