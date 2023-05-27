package kz.careerguidance.applicationapi.entity.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private int score;
    @ManyToOne
    @JoinColumn(name = "key_id")
    @Cascade(CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private ProfessionKey key;

    public Question() {

    }
}
