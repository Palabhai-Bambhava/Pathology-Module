package com.pathology.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "test_order")
public class TestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String patientName;
    
    @NotBlank
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "test_id")
    @NotNull
    private TestMaster test;
    
    @Column(unique = true)
    private String orderNumber;
    
    private LocalDate orderDate;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;
    
    public enum OrderStatus {
        PENDING, COMPLETED
    }
    
    // Constructors
    public TestOrder() {
        this.orderDate = LocalDate.now();
    }
    
    public TestOrder(String patientName, String phone, TestMaster test, String orderNumber) {
        this();
        this.patientName = patientName;
        this.phone = phone;
        this.test = test;
        this.orderNumber = orderNumber;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public TestMaster getTest() { return test; }
    public void setTest(TestMaster test) { this.test = test; }
    
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}