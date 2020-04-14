package com.flashcards.dto;

import com.flashcards.domain.FlashCardProgress;
import com.flashcards.domain.Language;
import com.flashcards.domain.dto.AmazonCardDto;
import com.flashcards.domain.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlashCardDto {
    private Long id;
    private String name;
    private Language language;
    private FlashCardProgress flashCardProgress;
    private LocalDateTime updated;
    private UserDto userDto;
    private AmazonCardDto amazonCardDto;
}
