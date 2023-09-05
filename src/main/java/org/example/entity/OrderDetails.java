package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "time_placed")
    private LocalDateTime timePlaced;
    private String comment;
    @Column(name = "time_updated")
    private LocalDateTime timeUpdated;
    @Column(name = "product_id")
    private int productId;

    @OneToOne
    @JoinColumn(name = "orders_id")
    private Order order;
}
