package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recommend_services")
public class RecommendServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id_rs")
    private Set<Results> surveyResults;

    @Column(name = "service_id")
    private Integer serviceId;


}