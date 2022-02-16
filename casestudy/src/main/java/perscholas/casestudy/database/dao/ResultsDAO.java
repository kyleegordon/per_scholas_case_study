package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.casestudy.database.entity.Results;

public interface ResultsDAO extends JpaRepository<Results, Long> {

}

