package perscholas.casestudy.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.entity.User;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
//
//        Recipe recipe = new Recipe();
//        Set<Recipe> recipes = new HashSet<Recipe>();
//        recipes.add(recipe);
        User user1 = new User();
        user1.setCompanyName("Test Company");
        user1.setEmail("unitTest@email.com");
        user1.setPassword("password");
        user1.setPhone("555-555-5555");
        user1.setWebsite("test.com");
        user1.setNumEmployees(5);
        user1.setIndustry("Test Industry");
        user1.setPersonalData(true);
        user1.setHealthcareData(true);
        user1.setCreditData(true);

        userDao.save(user1);

        //Assertions.assertThat(user1.getId()).isGreaterThan(0);
        Assertions.assertThat(userDao.findById(user1.getId()).getId()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void getUserTest() {
        User user = userDao.findById(1);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfUsers() {
        List<User> users = userDao.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userDao.findById(1);
        user.setCompanyName("Unit Test Update");
        Assertions.assertThat(userDao.findById(1).getCompanyName()).isEqualTo(user.getCompanyName());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userDao.findById(1);
        userDao.delete(user);
        Optional<User> optionalUser = Optional.ofNullable(userDao.findByEmail(user.getEmail()));

        User tempUser = null;
        if (optionalUser.isPresent()) {
            tempUser = optionalUser.get();
        }

        Assertions.assertThat(tempUser).isNull();
    }
}
