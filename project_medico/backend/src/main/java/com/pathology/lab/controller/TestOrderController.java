package com.pathology.lab.controller;

import com.pathology.lab.entity.TestOrder;
import com.pathology.lab.service.TestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class TestOrderController {
    
    @Autowired
    private TestOrderService testOrderService;
    
    @GetMapping
    public List<TestOrder> getAllOrders() {
        return testOrderService.getAllOrders();
    }
    
    @GetMapping("/today")
    public List<TestOrder> getTodayOrders() {
        return testOrderService.getTodayOrders();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TestOrder> getOrderById(@PathVariable Long id) {
        return testOrderService.getOrderById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<TestOrder> createOrder(@Valid @RequestBody TestOrder testOrder) {
        TestOrder created = testOrderService.createOrder(testOrder);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<TestOrder> updateOrderStatus(
            @PathVariable Long id, 
            @RequestBody Map<String, String> statusUpdate) {
        try {
            TestOrder.OrderStatus status = TestOrder.OrderStatus.valueOf(statusUpdate.get("status"));
            TestOrder updated = testOrderService.updateOrderStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}