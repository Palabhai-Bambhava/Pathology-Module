package com.pathology.lab.service;

import com.pathology.lab.entity.TestMaster;
import com.pathology.lab.repository.TestMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestMasterService {
    
    @Autowired
    private TestMasterRepository testMasterRepository;
    
    public List<TestMaster> getAllTests() {
        return testMasterRepository.findAll();
    }
    
    public Optional<TestMaster> getTestById(Long id) {
        return testMasterRepository.findById(id);
    }
    
    public TestMaster createTest(TestMaster testMaster) {
        if (testMasterRepository.existsByTestCode(testMaster.getTestCode())) {
            throw new RuntimeException("Test code already exists");
        }
        return testMasterRepository.save(testMaster);
    }
    
    public List<TestMaster> searchTestsByName(String name) {
        return testMasterRepository.findByTestNameContainingIgnoreCase(name);
    }
}