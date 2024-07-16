package at.grafolution.drinkolution.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private List<Player> players;
    // Getters and setters
    boolean isActive;
}