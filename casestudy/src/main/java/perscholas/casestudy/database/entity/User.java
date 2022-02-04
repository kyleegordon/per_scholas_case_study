package perscholas.casestudy.database.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User{

    @Id
    // this annotation is what tells hibernate that this variable is an auto
    // incremented primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

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

}