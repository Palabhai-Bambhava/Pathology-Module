package com.pathology.lab.repository;

import com.pathology.lab.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    
    List<TestOrder> findByOrderDate(LocalDate orderDate);
    
    @Query("SELECT COUNT(o) FROM TestOrder o WHERE DATE(o.orderDate) = CURRENT_DATE")
    Long countTodayOrders();
    
    boolean existsByOrderNumber(String orderNumber);
}