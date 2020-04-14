package com.flashcards.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20, name = "name", unique = true )
    private String name;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "language")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "userAppColor")
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserAppColor userAppColor;

    @OneToMany(
            targetEntity = FlashCard.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<FlashCard> flashCardList = new ArrayList<>();

}
