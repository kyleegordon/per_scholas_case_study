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

    @Column(name = "question")
    private String question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Services service;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    private Set<Results> results;


}