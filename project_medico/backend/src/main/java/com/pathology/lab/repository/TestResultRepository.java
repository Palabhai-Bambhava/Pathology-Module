package com.pathology.lab.repository;

import com.pathology.lab.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    
    Optional<TestResult> findByTestOrderId(Long orderId);
    
    boolean existsByTestOrderId(Long orderId);
}