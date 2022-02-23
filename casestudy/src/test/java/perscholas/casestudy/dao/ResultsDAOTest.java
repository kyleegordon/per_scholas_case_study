package perscholas.casestudy.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import perscholas.casestudy.database.dao.ResultsDAO;
import perscholas.casestudy.database.entity.Results;
import java.util.List;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ResultsDAOTest {

    @Autowired
    private ResultsDAO resultsDao;

    @Test
    @Order(1)
    public void getListOfResults() {
        List<Results> results = resultsDao.findAllByUserId(4);
        Assertions.assertThat(results.size()).isGreaterThan(0);
    }


}
