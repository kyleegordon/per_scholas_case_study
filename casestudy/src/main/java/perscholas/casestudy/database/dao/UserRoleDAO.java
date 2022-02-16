package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    public UserRole findByUserId(@Param("id") Integer id);
}
