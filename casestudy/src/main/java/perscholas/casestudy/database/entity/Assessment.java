package perscholas.casestudy.database.entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


//import com.google.gson.annotations.Expose;

@Getter
@Setter
@Entity
@Table(name = "assessment")
public class Assessment{

    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "question1")
    private Integer question1;

    @Column(name = "question2")
    private Integer question2;

    @Column(name = "question3")
    private Integer question3;

    @Column(name = "question4")
    private Integer question4;

    @Column(name = "question5")
    private Integer question5;

    @Column(name = "question6")
    private Integer question6;

    @Column(name = "question7")
    private Integer question7;

    @Column(name = "question8")
    private Integer question8;

    @Column(name = "question9")
    private Integer question9;

    @Column(name = "question10")
    private Integer question10;

    @Column(name = "question11")
    private Integer question11;

    @Column(name = "question12")
    private Integer question12;

    @Column(name = "question13")
    private Integer question13;

    @Column(name = "question14")
    private Integer question14;

    @Column(name = "question15")
    private Integer question15;

    @Column(name = "question16")
    private Integer question16;

    @Column(name = "question17")
    private Integer question17;

    @Column(name = "question18")
    private Integer question18;

    @Column(name = "security_score")
    private Integer securityScore;





}
