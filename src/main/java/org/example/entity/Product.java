package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nname;
    private BigDecimal price;
    private int quantity;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Order> orders;
}
