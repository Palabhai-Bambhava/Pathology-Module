package com.pathology.lab.service;

import com.pathology.lab.entity.TestOrder;
import com.pathology.lab.repository.TestOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TestOrderService {
    
    @Autowired
    private TestOrderRepository testOrderRepository;
    
    public List<TestOrder> getAllOrders() {
        return testOrderRepository.findAll();
    }
    
    public List<TestOrder> getTodayOrders() {
        return testOrderRepository.findByOrderDate(LocalDate.now());
    }
    
    public Optional<TestOrder> getOrderById(Long id) {
        return testOrderRepository.findById(id);
    }
    
    public TestOrder createOrder(TestOrder testOrder) {
        testOrder.setOrderNumber(generateOrderNumber());
        return testOrderRepository.save(testOrder);
    }
    
    public TestOrder updateOrderStatus(Long orderId, TestOrder.OrderStatus status) {
        TestOrder order = testOrderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return testOrderRepository.save(order);
    }
    
    private String generateOrderNumber() {
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long todayCount = testOrderRepository.countTodayOrders();
        return datePrefix + String.format("%03d", todayCount + 1);
    }
}