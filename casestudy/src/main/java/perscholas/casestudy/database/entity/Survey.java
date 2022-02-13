package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_survey")
    private User user;

    @Column(name = "survey_date")
    private String surveyDate;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Results> surveyResults;
}
