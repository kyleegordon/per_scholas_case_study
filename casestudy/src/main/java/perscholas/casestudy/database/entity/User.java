package perscholas.casestudy.database.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User{

    @Id
    // this annotation is what tells hibernate that this variable is an auto
    // incremented primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @Column(name = "number_employees")
    private Integer numEmployees;

    @Column(name = "industry")
    private String industry;

    @Column(name = "security_professionals")
    private boolean securityProfessionals;

    @Column(name = "personal_data")
    private boolean personalData;

    @Column(name = "healthcare_data")
    private boolean healthcareData;

    @Column(name = "credit_data")
    private boolean creditData;

    @Column(name = "other_data")
    private boolean otherData;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Results> results;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;

//    @ManyToMany
//    @JoinTable(
//            name = "user_results",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", unique = false)},
//            inverseJoinColumns = {@JoinColumn(name ="survey_id", referencedColumnName = "survey_id", unique = false)}
//    )
//    private List<Results> userResults = new ArrayList<Results>();

}