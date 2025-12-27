package com.pathology.lab.controller;

import com.pathology.lab.entity.TestMaster;
import com.pathology.lab.service.TestMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin(origins = "http://localhost:4200")
public class TestMasterController {
    
    @Autowired
    private TestMasterService testMasterService;
    
    @GetMapping
    public List<TestMaster> getAllTests() {
        return testMasterService.getAllTests();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TestMaster> getTestById(@PathVariable Long id) {
        return testMasterService.getTestById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<TestMaster> createTest(@Valid @RequestBody TestMaster testMaster) {
        try {
            TestMaster created = testMasterService.createTest(testMaster);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/search")
    public List<TestMaster> searchTests(@RequestParam String name) {
        return testMasterService.searchTestsByName(name);
    }
}