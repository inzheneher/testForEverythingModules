package repository;

import application.Application;
import entity.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * inzheneher created on 29/07/2020 inside the package - repository
 */
@DataJpaTest
@ContextConfiguration(classes = Application.class)
class RequestLogRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RequestLogRepository repository;

    @Test
    void testFindByTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Request request = new Request(timestamp, "20", "20", "respond json");
        entityManager.persist(request);
        List<Request> findByTimestamp = repository.findByTimestamp(timestamp);
        assertThat(findByTimestamp).extracting("timestamp").containsOnly(request.getTimestamp());
    }
}