package at.grafolution.drinkolution.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Quiz> quizzes;

    private boolean active;

    // Getters and setters
}