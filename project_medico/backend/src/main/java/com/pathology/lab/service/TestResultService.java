package com.pathology.lab.service;

import com.pathology.lab.entity.TestOrder;
import com.pathology.lab.entity.TestResult;
import com.pathology.lab.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TestResultService {
    
    @Autowired
    private TestResultRepository testResultRepository;
    
    @Autowired
    private TestOrderService testOrderService;
    
    public TestResult createResult(TestResult testResult) {
        if (testResultRepository.existsByTestOrderId(testResult.getTestOrder().getId())) {
            throw new RuntimeException("Result already exists for this order");
        }
        
        TestResult savedResult = testResultRepository.save(testResult);
        
        // Update order status to COMPLETED
        testOrderService.updateOrderStatus(testResult.getTestOrder().getId(), TestOrder.OrderStatus.COMPLETED);
        
        return savedResult;
    }
    
    public Optional<TestResult> getResultByOrderId(Long orderId) {
        return testResultRepository.findByTestOrderId(orderId);
    }
}