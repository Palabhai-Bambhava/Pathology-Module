package com.pathology.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    @NotNull
    private TestOrder testOrder;
    
    @NotBlank
    private String testResultValue;
    
    private String technicianNotes;
    
    private LocalDateTime resultDate;
    
    // Constructors
    public TestResult() {
        this.resultDate = LocalDateTime.now();
    }
    
    public TestResult(TestOrder testOrder, String testResultValue, String technicianNotes) {
        this();
        this.testOrder = testOrder;
        this.testResultValue = testResultValue;
        this.technicianNotes = technicianNotes;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public TestOrder getTestOrder() { return testOrder; }
    public void setTestOrder(TestOrder testOrder) { this.testOrder = testOrder; }
    
    public String getTestResultValue() { return testResultValue; }
    public void setTestResultValue(String testResultValue) { this.testResultValue = testResultValue; }
    
    public String getTechnicianNotes() { return technicianNotes; }
    public void setTechnicianNotes(String technicianNotes) { this.technicianNotes = technicianNotes; }
    
    public LocalDateTime getResultDate() { return resultDate; }
    public void setResultDate(LocalDateTime resultDate) { this.resultDate = resultDate; }
}