package model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String questionText;
    private int askedCounter;
    private double cost;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public int getHasBeenAsked() {
        return askedCounter;
    }
    public void hasBeenAsked() {
        this.askedCounter++;
    }
}
