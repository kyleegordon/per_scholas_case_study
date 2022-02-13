package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "survey_id")
    @JoinColumn(name = "id")
    private Set<Survey> survey;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Questions question;

    @Column(name = "answer")
    private Integer answer;

}