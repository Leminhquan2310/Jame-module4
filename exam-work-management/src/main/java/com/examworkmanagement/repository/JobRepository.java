package com.examworkmanagement.repository;

import com.examworkmanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j " +
            "WHERE (:status IS NULL OR j.status = :status) " +
            "AND (:name IS NULL OR LOWER(j.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:minTime IS NULL OR j.completedTime >= :minTime) " +
            "AND (:maxTime IS NULL OR j.completedTime <= :maxTime) " +
            "ORDER BY j.name ASC")
    List<Job> search(
            @Param("status") Integer status,
            @Param("name") String name,
            @Param("minTime") Integer minTime,
            @Param("maxTime") Integer maxTime
    );
}
