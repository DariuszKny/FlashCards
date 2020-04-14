package com.flashcards.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name= "flashCard")
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @NotNull
    @Column(name = "flashCardProgress")
    @Enumerated(EnumType.STRING)
    private FlashCardProgress flashCardProgress;

    @Column(name = "updated")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NonNull
    private User user;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "amazonCard_ID")
    private AmazonCard amazonCard;

}
