package com.task.transport.repos;

import com.task.transport.model.Transport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface TransportRepo extends CrudRepository<Transport, String>{
    @Query("SELECT t FROM Transport t WHERE (?1 is NULL OR t.stateNumber = ?1) AND (?2 is NULL OR t.brand = ?2) AND (?3 is NULL OR t.model = ?3)AND (?4 is NULL OR t.category = ?4)AND (?5 is NULL OR t.yearRelease = ?5)")
    List<Transport> findByFilter(String stateNumber, String brand, String model, String category, String yearRelease);
}
