package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.Survey;

public interface SurveyDAO extends JpaRepository<Survey, Long> {

    public Survey findById(@Param("id") Integer id);

}

