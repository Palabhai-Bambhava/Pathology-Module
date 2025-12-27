package com.pathology.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "test_master")
public class TestMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique = true)
    private String testName;
    
    @NotBlank
    @Column(unique = true)
    private String testCode;
    
    @NotBlank
    private String sampleType;
    
    private String normalRange;
    
    @NotNull
    @Positive
    private Double price;
    
    // Constructors
    public TestMaster() {}
    
    public TestMaster(String testName, String testCode, String sampleType, String normalRange, Double price) {
        this.testName = testName;
        this.testCode = testCode;
        this.sampleType = sampleType;
        this.normalRange = normalRange;
        this.price = price;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }
    
    public String getTestCode() { return testCode; }
    public void setTestCode(String testCode) { this.testCode = testCode; }
    
    public String getSampleType() { return sampleType; }
    public void setSampleType(String sampleType) { this.sampleType = sampleType; }
    
    public String getNormalRange() { return normalRange; }
    public void setNormalRange(String normalRange) { this.normalRange = normalRange; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}