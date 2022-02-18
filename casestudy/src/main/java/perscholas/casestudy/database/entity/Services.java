package perscholas.casestudy.database.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "service_description")
    private String serviceDescription;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private Set<Survey> surveys;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private Set<User> students = new HashSet<>();
}