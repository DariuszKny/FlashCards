package com.flashcards.repository;

import com.flashcards.domain.AmazonCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmazonCardRepository extends JpaRepository<AmazonCard, Long> {

    @Override
    List<AmazonCard> findAll();

    @Override
    Optional<AmazonCard> findById(Long id);

    @Override
    AmazonCard save(AmazonCard amazonCard);

    @Override
    void deleteById(Long id);

}
