package com.flashcards.mapper;

import com.flashcards.domain.AmazonCard;
import com.flashcards.domain.dto.AmazonCardDto;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AmazonCardMapperTest {


    private AmazonCardMapper amazonCardMapper = new AmazonCardMapper();

    @Test
    public void shouldMapToAmazonCard(){
        //given
        AmazonCardDto amazonCardDto = new AmazonCardDto(1L,null,"test");
        //when
        AmazonCard amazonCard = amazonCardMapper.mapToAmazonCard(amazonCardDto);
        //then
        assertEquals("test",amazonCard.getTranslation());
    }
    @Test
    public void shouldMapToAmazonCarDto(){
        //given
        AmazonCard amazonCard = new AmazonCard(1L,null,"test");
        //when
        AmazonCardDto amazonCardDto = amazonCardMapper.mapToAmazonCardDto(amazonCard);
        //then
        assertEquals("test",amazonCardDto.getTranslation());
    }

    @Test
    public void shouldMapToAmazonCarList(){
        //given
        List<AmazonCardDto> amazonCardDtoList = new ArrayList<>();
        AmazonCardDto amazonCardDto = new AmazonCardDto();
        amazonCardDto.setId(1L);
        amazonCardDto.setBytes(null);
        amazonCardDto.setTranslation("test");
        amazonCardDtoList.add(amazonCardDto);
        //when
        List<AmazonCard> amazonCardList = amazonCardMapper.mapToAmazonCardList(amazonCardDtoList);
        //then
        assertEquals(1,amazonCardList.size());
    }

    @Test
    public void shouldMapToAmazonCardDtoList(){
        //given
        List<AmazonCard> amazonCardList = new ArrayList<>();
        AmazonCard amazonCard = new AmazonCard();
        amazonCard.setId(1L);
        amazonCard.setBytes(null);
        amazonCard.setTranslation("test");
        amazonCardList.add(amazonCard);
        //when
        List<AmazonCardDto> amazonCardDtoList = amazonCardMapper.mapToAmazonCardDtoList(amazonCardList);
        //then
        assertEquals(1,amazonCardDtoList.size());
    }



}