package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name="date")
    private Date creationDate;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="gender")
    private String gender;
    @Column(name="country")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",
                            nullable = false, updatable = false)})
    private Set<Role> roles;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy="user")
    private Set<Question> questions;
    @OneToOne(mappedBy="debt")
    private Debt debt;

    public void askQuestion(String questionText) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setUser(this);
        question.hasBeenAsked();
        double auxdebt = debt.getValue();
        // this.setDebt(auxdebt+=question.getCost());
        questions.add(question);
    }

}
