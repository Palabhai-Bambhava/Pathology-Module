package com.pathology.lab.controller;

import com.pathology.lab.entity.TestResult;
import com.pathology.lab.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:4200")
public class TestResultController {
    
    @Autowired
    private TestResultService testResultService;
    
    @PostMapping
    public ResponseEntity<TestResult> createResult(@Valid @RequestBody TestResult testResult) {
        try {
            TestResult created = testResultService.createResult(testResult);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/order/{orderId}")
    public ResponseEntity<TestResult> getResultByOrderId(@PathVariable Long orderId) {
        return testResultService.getResultByOrderId(orderId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}