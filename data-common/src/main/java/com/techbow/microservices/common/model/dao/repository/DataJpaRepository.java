package com.techbow.microservices.common.model.dao.repository;

import com.techbow.microservices.common.model.dvo.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Spring provided JPA
public interface DataJpaRepository extends JpaRepository<Data, Long> {

    //JPA Query customization & configure
    @Query(value = "SELECT * FROM data LIMIT :limit", nativeQuery = true)
    List<Data> findAllByLimit(@Param("limit") Integer limit);
    
    //@Query(value = "SELECT * FROM data WHERE clientId in :clientId", nativeQuery = true)
    List<Data> findByClientId(Long clientId);
    
    //@Query(value = "SELECT * FROM data WHERE clientId in :clientId ORDER BY stepCount", nativeQuery = true)
    List<Data> findByClientIdOrderByStepCount(Long clientId);
    
    //@Query(value = "SELECT * FROM data WHERE clientId in :clientId ORDER BY stepCount DESC", nativeQuery = true)
    List<Data> findByClientIdOrderByStepCountDesc(Long clientId);
    
    //@Query(value = "SELECT * FROM data WHERE clientId in :clientId AND stepCount BETWEEN :start AND :end", nativeQuery = true)
    List<Data> findByClientIdAndStepCountIsBetween(Long clientId, Integer start, Integer end);
}
