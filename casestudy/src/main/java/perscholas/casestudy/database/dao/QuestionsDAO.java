package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.casestudy.database.entity.Questions;

public interface QuestionsDAO extends JpaRepository<Questions, Long> {

}

