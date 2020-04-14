package com.flashcards.service;

import com.flashcards.domain.AmazonCard;
import com.flashcards.domain.dto.AmazonCardDto;
import com.flashcards.mapper.AmazonCardMapper;
import com.flashcards.repository.AmazonCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonCardService {

    private AmazonCardRepository amazonCardRepository;
    private AmazonCardMapper amazonCardMapper;

    public AmazonCardService(AmazonCardRepository amazonCardRepository, AmazonCardMapper amazonCardMapper) {
        this.amazonCardRepository = amazonCardRepository;
        this.amazonCardMapper = amazonCardMapper;
    }

    public List<AmazonCardDto> getAllCards(){
        return amazonCardMapper.mapToAmazonCardDtoList(amazonCardRepository.findAll());
    }

    public AmazonCardDto getAmazonCardById(final Long Id) throws RuntimeException {
        return amazonCardMapper.mapToAmazonCardDto(amazonCardRepository.findById(Id).orElseThrow(() -> new RuntimeException()));
    }

    public AmazonCard saveAmazonCard(final AmazonCardDto amazonCardDto){
        return amazonCardRepository.save(amazonCardMapper.mapToAmazonCard(amazonCardDto));
    }

    public void deleteAmazonCard(final Long id){
        amazonCardRepository.deleteById(id);
    }

}
