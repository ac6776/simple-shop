package com.mysimpleshop.simpleshop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;

    @NotNull(message = "Tittle cannot be null")
    @Size(min = 6, message = "Title length must be greater than 5 symbols")
    @Column
    private String title;

    @NotNull(message = "Cost cannot be null")
    @Min(value = 1, message = "Min cost error")
    @Column
    private double cost;
}
