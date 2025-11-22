package com.examworkmanagement.repository;

import com.examworkmanagement.entity.PriorityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityLevelRepository extends JpaRepository<PriorityLevel, Long> {
}
