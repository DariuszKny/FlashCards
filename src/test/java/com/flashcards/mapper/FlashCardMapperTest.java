package com.flashcards.mapper;

import com.flashcards.domain.*;
import com.flashcards.domain.dto.AmazonCardDto;
import com.flashcards.domain.dto.UserDto;
import org.junit.Test;
import com.flashcards.dto.FlashCardDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlashCardMapperTest {

    private AmazonCardMapper amazonCardMapper = new AmazonCardMapper();
    private UserMapper userMapper = new UserMapper();
    private FlashCardMapper flashCardMapper = new FlashCardMapper(amazonCardMapper,userMapper);


    @Test
    public void mapToFlashCardDto() {
        //Given
        FlashCard flashCard = new FlashCard();
        flashCard.setId(1L);
        flashCard.setName("test");
        flashCard.setLanguage(Language.ENGLISH);
        flashCard.setFlashCardProgress(FlashCardProgress.NEW);
        flashCard.setUpdated(LocalDateTime.now());
        flashCard.setUser(new User());
        flashCard.setAmazonCard(new AmazonCard());
        //When
       FlashCardDto flashCardDto = flashCardMapper.mapToFlashCardDto(flashCard);
        //Then
        assertTrue(flashCardDto.getId()==1L);
        assertEquals("test",flashCardDto.getName());
    }

    @Test
    public void mapToFlashCard() {
        //Given
        FlashCardDto flashCardDto11 = new FlashCardDto(2L,"test",Language.ENGLISH,FlashCardProgress.BAD,LocalDateTime.now(),new UserDto(),new AmazonCardDto());
        FlashCardDto flashCardDto = new FlashCardDto();
        flashCardDto.setId(1L);
        flashCardDto.setName("test");
        flashCardDto.setLanguage(Language.ENGLISH);
        flashCardDto.setFlashCardProgress(FlashCardProgress.NEW);
        flashCardDto.setUpdated(LocalDateTime.now());
        flashCardDto.setUserDto(new UserDto());
        flashCardDto.setAmazonCardDto(new AmazonCardDto());
        //When
        FlashCard flashCard = flashCardMapper.mapToFlashCard(flashCardDto);
        FlashCard flashCard1 = flashCardMapper.mapToFlashCard(flashCardDto11);
        //Then
        assertTrue(flashCard.getId()==1L);
        assertEquals("test",flashCard1.getName());
    }

    @Test
    public void mapToFlashCardDtoList() {
        //Given
        List<FlashCard> flashCardList = new ArrayList<>();
        FlashCard flashCard = new FlashCard();
        flashCard.setId(1L);
        flashCard.setName("test");
        flashCard.setLanguage(Language.ENGLISH);
        flashCard.setFlashCardProgress(FlashCardProgress.NEW);
        flashCard.setUpdated(LocalDateTime.now());
        flashCard.setUser(new User());
        flashCard.setAmazonCard(new AmazonCard());
        flashCardList.add(flashCard);
        //When
        List<FlashCardDto> flashCardDtoList = flashCardMapper.mapToFlashCardDtoList(flashCardList);
        //Then
        assertEquals(1,flashCardDtoList.size());
    }
}