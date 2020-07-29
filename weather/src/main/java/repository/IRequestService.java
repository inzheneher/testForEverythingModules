package repository;

import entity.Request;

import java.util.List;

/**
 * inzheneher created on 28/07/2020 inside the package - repository
 */
public interface IRequestService {
    List<Request> findAll();
}
