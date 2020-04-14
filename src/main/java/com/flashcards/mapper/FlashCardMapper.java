package com.flashcards.mapper;

import com.flashcards.domain.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.flashcards.dto.FlashCardDto;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlashCardMapper {

    private AmazonCardMapper amazonCardMapper;
    private UserMapper userMapper;

    public FlashCardMapper(AmazonCardMapper amazonCardMapper, UserMapper userMapper) {
        this.amazonCardMapper = amazonCardMapper;
        this.userMapper = userMapper;
    }

    public FlashCard mapToFlashCard(final FlashCardDto flashCardDto) {
        return new FlashCard(
                flashCardDto.getId(),
                flashCardDto.getName(),
                flashCardDto.getLanguage(),
                flashCardDto.getFlashCardProgress(),
                flashCardDto.getUpdated(),
                userMapper.mapToUser(flashCardDto.getUserDto()),
                amazonCardMapper.mapToAmazonCard(flashCardDto.getAmazonCardDto())
        );
    }

    public FlashCardDto mapToFlashCardDto(final FlashCard flashCard) {
        return new FlashCardDto(
                flashCard.getId(),
                flashCard.getName(),
                flashCard.getLanguage(),
                flashCard.getFlashCardProgress(),
                flashCard.getUpdated(),
                userMapper.mapToUserDto(flashCard.getUser()),
                amazonCardMapper.mapToAmazonCardDto(flashCard.getAmazonCard())
        );
    }

    public List<FlashCardDto> mapToFlashCardDtoList(List<FlashCard> flashCardList){
        return flashCardList.stream().map(flashCard -> new FlashCardDto(flashCard.getId(),
                flashCard.getName(),
                flashCard.getLanguage(),
                flashCard.getFlashCardProgress(),
                flashCard.getUpdated(),
                userMapper.mapToUserDto(flashCard.getUser()),
                amazonCardMapper.mapToAmazonCardDto(flashCard.getAmazonCard())))
                .collect(Collectors.toList());
    }

}
