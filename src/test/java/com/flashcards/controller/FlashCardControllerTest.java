package com.flashcards.controller;

import com.flashcards.domain.FlashCardProgress;
import com.flashcards.domain.Language;
import com.flashcards.domain.User;
import com.flashcards.domain.UserAppColor;
import com.flashcards.domain.dto.AmazonCardDto;
import com.flashcards.domain.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.flashcards.dto.FlashCardDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FlashCardControllerTest {

    @Autowired
    private FlashCardController flashCardController;

    @Autowired
    private AmazonCardController amazonCardController;

    @Autowired
    private UserController userController;

    @Test
    public void shouldGetEmptyList() throws Exception {
//        Given
//        When
        List<FlashCardDto> flashCardDtoList = flashCardController.getAllFlashCards();
//        THen
        assertEquals(0, flashCardDtoList.size());
    }

    @Test
    public void shouldAddAndDeleteFlashCard() throws Exception {
//        Given
        AmazonCardDto amazonCardDto = new AmazonCardDto(5L, null, "test");
        amazonCardController.addAmazonCard(amazonCardDto);
        UserDto userDto = new UserDto(2L,"test","test","test@test.com", Language.ENGLISH, UserAppColor.DARK,new ArrayList<>());
        userController.addUser(userDto);
        FlashCardDto flashCardDto = new FlashCardDto(4L,"test", Language.ENGLISH, FlashCardProgress.BAD, LocalDateTime.now(),userDto,amazonCardDto);
        flashCardController.addFlashCard(flashCardDto);
//        When
        List<FlashCardDto> flashCardDtos = flashCardController.getAllFlashCards();
        FlashCardDto flashCarsById = flashCardController.getFlashCarsById(4L);
        flashCardController.deleteFlashCard(4L);
        List<FlashCardDto> flashCardDtos1 = flashCardController.getAllFlashCards();
//        THen
        assertTrue(flashCarsById.getId() == 4L);
        assertEquals(0, flashCardDtos1.size());
    }

    @Test
    public void shouldUpdateFlashCard() throws Exception {
//        Given
        FlashCardDto amazonCardDto = new FlashCardDto(1L,"test",Language.ENGLISH,FlashCardProgress.BAD,LocalDateTime.now(),new UserDto(),new AmazonCardDto());
        flashCardController.addFlashCard(amazonCardDto);
//        When
        flashCardController.updateFlashCard(new FlashCardDto(1L,"updated",Language.ENGLISH,FlashCardProgress.BAD,LocalDateTime.now(),new UserDto(),new AmazonCardDto()));
        FlashCardDto flashCarsById = flashCardController.getFlashCarsById(1L);
//        THen
        assertEquals("updated",flashCarsById.getName());
    }

    @Test
    public void shouldFindFlashCardByUserIDAndLanguageAndProgress() throws Exception {
//        Given
        UserDto userDto = new UserDto(1L,"test","test","test@test.com", Language.ENGLISH, UserAppColor.DARK,new ArrayList<>());
        userController.addUser(userDto);
        AmazonCardDto amazonCardDto = new AmazonCardDto(4L, null, "test");
        amazonCardController.addAmazonCard(amazonCardDto);
        FlashCardDto flashCardDto = new FlashCardDto(3L,"test",Language.ENGLISH,FlashCardProgress.BAD,LocalDateTime.now(),userDto,amazonCardDto);
        FlashCardDto flashCardDto1 = new FlashCardDto(4L,"test",Language.ENGLISH,FlashCardProgress.NEW,LocalDateTime.now(),userDto,amazonCardDto);
        flashCardController.addFlashCard(flashCardDto);
        flashCardController.addFlashCard(flashCardDto1);
//        When
        List<FlashCardDto> flashCardsByUserId = flashCardController.getFlashCardsByUserId(1L,Language.ENGLISH);
        List<FlashCardDto> flashCardsByUserIdLanguageProgress = flashCardController.getFlashCardsByUserIdLanguageProgress(1L,Language.ENGLISH,FlashCardProgress.NEW);
//        THen
        assertEquals(2,flashCardsByUserId.size());
        assertEquals(1,flashCardsByUserIdLanguageProgress.size());
    }

}