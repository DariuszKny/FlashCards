package com.flashcards.controller;

import com.flashcards.domain.Language;
import com.flashcards.domain.UserAppColor;
import com.flashcards.domain.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void shouldGetEmptyUserList() throws Exception {
//        Given
//        When
        List<UserDto> userDtos = userController.getAllUsers();
//        THen
        assertEquals(0, userDtos.size());
    }

    @Test
    public void shouldAddAndDeleteUser() throws Exception {
//        Given
        UserDto userDto = new UserDto(4L,"test","test","test@test.com", Language.ENGLISH, UserAppColor.DARK,new ArrayList<>());
        userController.addUser(userDto);
//        When
        UserDto usersById = userController.getUsersById(4L);
        userController.deleteUser(4L);
        List<UserDto> amazonCardDtos = userController.getAllUsers();
//        THen
        assertTrue(usersById.getId() == 4L);
        assertEquals(0, amazonCardDtos.size());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
//        Given
        UserDto userDto = new UserDto(3L,"test","test","test@test.com", Language.ENGLISH, UserAppColor.DARK,new ArrayList<>());
        userController.addUser(userDto);
//        When
        userController.updateUser(new UserDto(3L,"updated","test","test@test.com", Language.ENGLISH, UserAppColor.DARK,new ArrayList<>()));
        UserDto usersById = userController.getUsersById(3L);
//        THen
        assertEquals("updated",usersById.getName());
    }

}