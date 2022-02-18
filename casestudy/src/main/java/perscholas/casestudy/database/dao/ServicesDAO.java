package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.Services;
import perscholas.casestudy.database.entity.User;


public interface ServicesDAO extends JpaRepository<Services, Long> {
    public Services findById(@Param("id") Integer id);
}
