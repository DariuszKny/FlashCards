package com.flashcards.controller;

import com.flashcards.amazon.AmazonPollyService;
import com.flashcards.amazon.AmazonTranslateService;
import com.flashcards.domain.Language;
import com.flashcards.domain.dto.AmazonCardDto;
import com.flashcards.service.AmazonCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/amazonCard")
public class AmazonCardController {

    private AmazonPollyService amazonPollyService;
    private AmazonTranslateService amazontranslateService;
    private AmazonCardService amazonCardService;


    public AmazonCardController(AmazonPollyService amazonPollyService, AmazonTranslateService amazontranslateService, AmazonCardService amazonCardService) {
        this.amazonPollyService = amazonPollyService;
        this.amazontranslateService = amazontranslateService;
        this.amazonCardService = amazonCardService;
    }

    @GetMapping(value = "getAudio")
    public byte[] getAudio(@RequestParam String text,@RequestParam Language language) throws Exception {
        return amazonPollyService.getAudio(text, language);
    }

    @GetMapping(value = "getTranslate")
    public String getTranslate(@RequestParam String text,@RequestParam  Language language){
        return amazontranslateService.translate(text, language);
    }

    @GetMapping(value = "getAmazonCards")
    public List<AmazonCardDto> getAllCards(){
        return amazonCardService.getAllCards();
    }

    @GetMapping(value = "getAmazonCard")
    public AmazonCardDto getAmazonCardById(@RequestParam long id){
        return amazonCardService.getAmazonCardById(id);
    }

    @PostMapping(value = "addAmazonCard")
    public void addAmazonCard(@RequestBody AmazonCardDto amazonCardDto){
        amazonCardService.saveAmazonCard(amazonCardDto);
    }

    @PutMapping(value = "updateAmazonCard")
    public void updateAmazonCard(@RequestBody AmazonCardDto amazonCardDto){
        amazonCardService.saveAmazonCard(amazonCardDto);
    }

    @DeleteMapping(value = "deleteAmazonCard")
    public void deleteAmazonCard(@RequestParam long id){
        amazonCardService.deleteAmazonCard(id);
    }
}
