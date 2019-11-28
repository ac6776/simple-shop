package com.mysimpleshop.simpleshop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "products")
@Data
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @NotNull(message = "категория не выбрана")
    @JoinColumn(name = "category_id")
    private Category category;

//    @Column(name = "vendor_code")
    @NotNull(message = "не может быть пустым")
    @Pattern(regexp = "([0-9]{1,})", message = "недопустимый символ")
    @Size(min = 8, max = 8, message = "требуется 8 числовых символов")
    private String vendorCode;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "product")
    private List<ProductImage> images;

    @NotNull(message = "Tittle cannot be null")
    @Size(min = 4, message = "Title length must be greater than 4 symbols")
    @Column
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @NotNull(message = "Cost cannot be null")
    @Min(value = 1, message = "Min cost error")
    @Column
    private double cost;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

    public void addImage(ProductImage productImage) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(productImage);
    }
}
