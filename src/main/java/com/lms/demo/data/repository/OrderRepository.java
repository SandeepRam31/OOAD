package com.lms.demo.data.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.lms.demo.data.model.Order;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Modifying
    @Transactional
    @Query(value = "delete from Order c where c.booking_id = ?1")
    void deleteByOrderId(String orderId);
}
