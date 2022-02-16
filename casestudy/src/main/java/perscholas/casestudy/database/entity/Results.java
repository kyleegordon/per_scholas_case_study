package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id")
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "answer")
    private Integer answer;

    @Column(name = "date")
    private String date;

    @Column(name = "user_id")
    private Integer userId;

//    @ManyToMany (mappedBy = "userResults")
//    private List<User> userResults = new ArrayList<>();

}