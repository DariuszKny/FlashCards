package com.flashcards.domain.dto;

import com.flashcards.domain.Language;
import com.flashcards.domain.UserAppColor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.flashcards.dto.FlashCardDto;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private Language language;
    @NotNull
    private UserAppColor userAppColor;
    private List<FlashCardDto> flashCardDtoList;
}
