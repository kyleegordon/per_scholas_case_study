package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.Results;
import java.util.List;

public interface ResultsDAO extends JpaRepository<Results, Long> {

    public List <Results> findAllByUserId(@Param("id") Integer id);

}

