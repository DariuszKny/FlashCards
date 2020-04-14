package com.flashcards.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AmazonCardDto {

    private Long id;
    private byte[] bytes;
    private String translation;
}
