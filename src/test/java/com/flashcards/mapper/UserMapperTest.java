package com.flashcards.mapper;

import com.flashcards.domain.Language;
import com.flashcards.domain.User;
import com.flashcards.domain.UserAppColor;
import com.flashcards.domain.dto.UserDto;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private UserMapper userMapper = new UserMapper();


    @Test
    public void mapToUser() {
        //Given
        UserDto userDto = new UserDto(1L,"name","password","email@test.com", Language.ENGLISH, UserAppColor.LIGHT,new ArrayList<>());
        UserDto userDto1 = new UserDto();
        userDto1.setId(2L);
        userDto1.setName("name");
        userDto1.setEmail("email@email.com");
        userDto1.setLanguage(Language.ENGLISH);
        userDto1.setUserAppColor(UserAppColor.LIGHT);
        userDto1.setFlashCardDtoList(new ArrayList<>());
        //When
        User user = userMapper.mapToUser(userDto);
        User user1 = userMapper.mapToUser(userDto1);
        //Then
        assertTrue(user.getId()==1L);
        assertEquals("name",user.getName());
        assertTrue(user1.getId()==2L);
        assertEquals("name",user1.getName());
    }

    @Test
    public void mapToUserDto() {
        //Given
        User user = new User(1L,"name","password","email@test.com", Language.ENGLISH, UserAppColor.LIGHT,new ArrayList<>());
        User user1 = new User();
        user1.setId(2L);
        user1.setName("name");
        user1.setEmail("email@email.com");
        user1.setLanguage(Language.ENGLISH);
        user1.setUserAppColor(UserAppColor.LIGHT);
        user1.setFlashCardList(new ArrayList<>());
        //When
        UserDto userDto = userMapper.mapToUserDto(user);
        UserDto userDto1 = userMapper.mapToUserDto(user1);
        //Then
        assertTrue(user.getId()==1L);
        assertEquals("name",user.getName());
        assertTrue(user1.getId()==2L);
        assertEquals("name",user1.getName());
    }

    @Test
    public void mapToUserDtoList() {
        //Given
        List<User> userList = new ArrayList<>();
        User user = new User(1L,"name","password","email@test.com", Language.ENGLISH, UserAppColor.LIGHT,new ArrayList<>());
        userList.add(user);
        //When
        List<UserDto> userDtos = userMapper.mapToUserDtoList(userList);
        //Then
        assertEquals(1, userDtos.size());
    }
}