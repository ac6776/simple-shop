package com.mysimpleshop.simpleshop.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Product {
    private Long id;
    private String title;
    private double cost;
}
