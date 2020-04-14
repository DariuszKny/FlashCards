package com.flashcards.service;

import com.flashcards.domain.AmazonCard;
import com.flashcards.domain.FlashCard;
import com.flashcards.domain.FlashCardProgress;
import com.flashcards.domain.Language;
import com.flashcards.mapper.AmazonCardMapper;
import com.flashcards.mapper.FlashCardMapper;
import com.flashcards.repository.FlashCardRepository;
import org.springframework.stereotype.Service;
import com.flashcards.dto.FlashCardDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlashCardService {

    private FlashCardRepository flashCardRepository;
    private FlashCardMapper flashCardMapper;
    private AmazonCardMapper amazonCardMapper;
    private AmazonCardService amazonCardService;

    public FlashCardService(FlashCardRepository flashCardRepository, FlashCardMapper flashCardMapper, AmazonCardMapper amazonCardMapper, AmazonCardService amazonCardService) {
        this.flashCardRepository = flashCardRepository;
        this.flashCardMapper = flashCardMapper;
        this.amazonCardMapper = amazonCardMapper;
        this.amazonCardService = amazonCardService;
    }

    public List<FlashCardDto> getAllFlashCards(){
        return flashCardMapper.mapToFlashCardDtoList(flashCardRepository.findAll());
    }

    public void addFlashCard(final FlashCardDto flashCardDto){
        AmazonCard amazonCard = amazonCardMapper.mapToAmazonCard(flashCardDto.getAmazonCardDto());
        amazonCardService.saveAmazonCard(amazonCardMapper.mapToAmazonCardDto(amazonCard));
        FlashCard flashCard = flashCardMapper.mapToFlashCard(flashCardDto);
        flashCard.setAmazonCard(amazonCard);
        flashCardRepository.save(flashCard);
    }


    public FlashCardDto getFlashCardById(final Long flashCardId) throws RuntimeException {
        return flashCardMapper.mapToFlashCardDto(flashCardRepository.findById(flashCardId).orElseThrow(() -> new RuntimeException()));
    }

    public FlashCard saveFlashCard(final FlashCard flashCard){
        return flashCardRepository.save(flashCard);
    }

    public void deleteFlashCard(final Long id){
        flashCardRepository.deleteById(id);
    }

    public List<FlashCardDto> getAllCardsByUserIdAndLanguage(final Long userId, final Language language){
        return flashCardMapper.mapToFlashCardDtoList(flashCardRepository.findAllByUser_IdAndAndLanguage(userId, language));
    }

    public List<FlashCardDto> getAllCardsByUserIdAndLanguageAndProgress(final Long userId, final Language language, final FlashCardProgress flashCardProgress){
        return flashCardMapper.mapToFlashCardDtoList(flashCardRepository.findAllByUser_IdAndAndLanguageAndFlashCardProgress(userId, language,flashCardProgress));
    }

    public FlashCard updateFleshCard(FlashCardDto flashCardDto){
        flashCardDto.setUpdated(LocalDateTime.now());
        return flashCardRepository.save(flashCardMapper.mapToFlashCard(flashCardDto));
    }
}
