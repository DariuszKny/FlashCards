package com.flashcards.repository;

import com.flashcards.domain.FlashCard;
import com.flashcards.domain.FlashCardProgress;
import com.flashcards.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {

    @Override
    List<FlashCard> findAll();

    @Override
    Optional<FlashCard> findById(Long id);

    @Override
    FlashCard save(FlashCard flashCard);



    @Override
    void deleteById(Long id);

    List<FlashCard> findAllByUser_IdAndAndLanguage(Long id, Language language);

    List<FlashCard> findAllByUser_IdAndAndLanguageAndFlashCardProgress(Long id, Language language, FlashCardProgress flashCardProgress);
}
