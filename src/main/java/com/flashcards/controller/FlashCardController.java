package com.flashcards.controller;

import com.flashcards.domain.FlashCardProgress;
import com.flashcards.domain.Language;
import com.flashcards.dto.FlashCardDto;
import com.flashcards.service.FlashCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flashCard")
public class FlashCardController {

    private FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @PostMapping(value = "addFlashCard")
    public void addFlashCard(@RequestBody FlashCardDto flashCardDto){
       flashCardService.addFlashCard(flashCardDto);
    }


    @GetMapping(value = "getAllFlashCards")
    public List<FlashCardDto>  getAllFlashCards(){
        return flashCardService.getAllFlashCards();
    }

    @GetMapping(value = "getFlashCard")
    public FlashCardDto getFlashCarsById(@RequestParam Long flashCardId){
        return flashCardService.getFlashCardById(flashCardId);
    }

    @GetMapping(value = "getFlashCards")
    public List<FlashCardDto> getFlashCardsByUserId(@RequestParam Long userId, @RequestParam Language language){
        return flashCardService.getAllCardsByUserIdAndLanguage(userId, language);
    }


    @GetMapping(value = "getFlashCardsByProgress")
    public List<FlashCardDto> getFlashCardsByUserIdLanguageProgress(@RequestParam Long userId, @RequestParam Language language, @RequestParam FlashCardProgress flashCardProgress){
        return flashCardService.getAllCardsByUserIdAndLanguageAndProgress(userId, language, flashCardProgress);
    }


    @PutMapping(value = "updateFlashCard")
    public void updateFlashCard(@RequestBody FlashCardDto flashCardDto){
       flashCardService.updateFleshCard(flashCardDto);
    }

    @DeleteMapping(value = "deleteFlashCard")
    public void deleteFlashCard(@RequestParam Long flashCardId){
        flashCardService.deleteFlashCard(flashCardId);
    }

}
