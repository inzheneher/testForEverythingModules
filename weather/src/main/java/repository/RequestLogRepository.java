package repository;

import entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * inzheneher created on 28/07/2020 inside the package - com.mav.repository
 */
@Repository
public interface RequestLogRepository extends CrudRepository<Request, Long> {

    List<Request> findByTimestamp(Timestamp timestamp);

    Request findById(long id);
}
