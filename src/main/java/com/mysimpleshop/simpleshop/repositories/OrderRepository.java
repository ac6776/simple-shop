package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
