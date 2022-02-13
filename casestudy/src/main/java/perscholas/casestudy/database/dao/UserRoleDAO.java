package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.casestudy.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

}
