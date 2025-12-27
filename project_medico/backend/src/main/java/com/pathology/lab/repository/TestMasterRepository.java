package com.pathology.lab.repository;

import com.pathology.lab.entity.TestMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestMasterRepository extends JpaRepository<TestMaster, Long> {
    
    @Query("SELECT t FROM TestMaster t WHERE LOWER(t.testName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<TestMaster> findByTestNameContainingIgnoreCase(@Param("name") String name);
    
    boolean existsByTestCode(String testCode);
}