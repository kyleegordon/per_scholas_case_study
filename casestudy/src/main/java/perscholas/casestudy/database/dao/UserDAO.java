package perscholas.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.database.entity.UserRole;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    //^^documentation with query method keywords ^^

    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId") Integer userId);


}
