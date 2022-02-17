package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.Results;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.database.entity.UserRole;

import java.util.List;

public interface ResultsDAO extends JpaRepository<Results, Long> {

//    @Query("select r from Results r where r.userId = :userId")
//    List<Results> getUserResults(@Param("userId") Integer userId);
}

