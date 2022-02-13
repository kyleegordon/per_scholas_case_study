package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Results {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Set<Survey> survey;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "answer")
    private Integer answer;

}