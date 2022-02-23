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
import perscholas.casestudy.database.dao.ServicesDAO;
import perscholas.casestudy.database.entity.Services;



@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServicesDAOTest {

    @Autowired
    private ServicesDAO servicesDao;

    static Integer testId;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveServiceTest() {

        Services service1 = new Services();
        service1.setServiceName("Test Name");
        service1.setServiceDescription("Test Description");
        service1.setVariable("testVariable");

        servicesDao.save(service1);

        testId = service1.getId();
        System.out.println("User TEST ID" + testId);

        Assertions.assertThat(servicesDao.findById(service1.getId()).getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getServiceTest() {
        Services service = servicesDao.findById(testId);
        Assertions.assertThat(service.getId()).isEqualTo(testId);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateServiceTest() {
        Services service = servicesDao.findById(testId);
        service.setServiceName("Unit Test Update");
        Assertions.assertThat(servicesDao.findById(testId).getServiceName()).isEqualTo(service.getServiceName());
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteUserTest() {
        Services service = servicesDao.findById(testId);
        servicesDao.delete(service);
        Services tempService = servicesDao.findById(testId);


        Assertions.assertThat(tempService).isNull();
    }
}
