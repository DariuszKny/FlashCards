package com.flashcards.controller;

import com.flashcards.domain.dto.AmazonCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AmazonCardControllerTest {

    @Autowired
    private AmazonCardController amazonCardController;

    @Test
    public void shouldGetEmptyList() throws Exception {
//        Given
//        When
        List<AmazonCardDto> amazonCardDtos = amazonCardController.getAllCards();
//        THen
        assertEquals(0, amazonCardDtos.size());
    }

    @Test
    public void shouldAddAndDeleteAmazonCard() throws Exception {
//        Given
        AmazonCardDto amazonCardDto = new AmazonCardDto(2L, null, "test");
        amazonCardController.addAmazonCard(amazonCardDto);
//        When
        AmazonCardDto amazonCardById = amazonCardController.getAmazonCardById(2L);
        amazonCardController.deleteAmazonCard(2L);
        List<AmazonCardDto> amazonCardDtos = amazonCardController.getAllCards();
//        THen
        assertTrue(amazonCardById.getId() == 2L);
        assertEquals(0, amazonCardDtos.size());
    }

    @Test
    public void shouldUpdateAmazonCard() throws Exception {
//        Given
        AmazonCardDto amazonCardDto = new AmazonCardDto(1L, null, "test");
        amazonCardController.addAmazonCard(amazonCardDto);
//        When
        amazonCardController.updateAmazonCard(new AmazonCardDto(1L,null,"updated"));
        AmazonCardDto amazonCardById = amazonCardController.getAmazonCardById(1L);
//        THen
        assertEquals("updated",amazonCardById.getTranslation());
    }
}