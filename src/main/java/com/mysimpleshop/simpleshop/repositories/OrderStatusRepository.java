package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
}
