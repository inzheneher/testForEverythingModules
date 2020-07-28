package com.mav.repository;

import com.mav.entity.Request;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * inzheneher created on 28/07/2020 inside the package - com.mav.repository
 */
public interface RequestLogRepository extends CrudRepository<Request, Long> {

    List<Request> findByTimestamp(Timestamp timestamp);

    Request findById(long id);
}
