package perscholas.casestudy.database.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User{

    @Id
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

    @Column(name = "personal_data")
    private boolean personalData;

    @Column(name = "healthcare_data")
    private boolean healthcareData;

    @Column(name = "credit_data")
    private boolean creditData;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Results> results;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_services",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "service_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Services> services = new HashSet<>();

}