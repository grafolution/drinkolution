package at.grafolution.drinkolution.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sessionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


}
