package com.flashcards.mapper;

import com.flashcards.domain.AmazonCard;
import com.flashcards.domain.dto.AmazonCardDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AmazonCardMapper {

    public AmazonCard mapToAmazonCard(final AmazonCardDto amazonCardDto){
        return new AmazonCard(
                amazonCardDto.getId(),
                amazonCardDto.getBytes(),
                amazonCardDto.getTranslation());
    }

    public AmazonCardDto mapToAmazonCardDto(final AmazonCard amazonCard){
        return new AmazonCardDto(
                amazonCard.getId(),
                amazonCard.getBytes(),
                amazonCard.getTranslation());
    }

    public List<AmazonCard> mapToAmazonCardList(final List<AmazonCardDto> amazonCardDtoList){
        return amazonCardDtoList.stream().map(amazonCardDto -> new AmazonCard(
                amazonCardDto.getId(),
                amazonCardDto.getBytes(),
                amazonCardDto.getTranslation()))
                .collect(Collectors.toList());
    }

    public List<AmazonCardDto> mapToAmazonCardDtoList(final List<AmazonCard> amazonCardList){
        return amazonCardList.stream().map(amazonCard -> new AmazonCardDto(
                amazonCard.getId(),
                amazonCard.getBytes(),
                amazonCard.getTranslation()))
                .collect(Collectors.toList());
    }
}
