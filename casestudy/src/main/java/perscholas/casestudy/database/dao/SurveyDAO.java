package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.casestudy.database.entity.Survey;

public interface SurveyDAO extends JpaRepository<Survey, Long> {

}

