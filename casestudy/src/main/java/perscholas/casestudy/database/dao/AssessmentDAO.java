package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.Assessment;
import perscholas.casestudy.database.entity.User;
import java.util.List;

public interface AssessmentDAO extends JpaRepository<Assessment, Long> {

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    //^^documentation with query method keywords ^^
    //these just magically work without having to write the code for each method

    //    @Query("select u from User u where u.id = :id")
    public User findById(@Param("id") Integer id);


}