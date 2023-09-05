package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    String email;
    @Column(name = "role")
    String role;
    @Column(name = "username")
    String username;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "user_id")
    private Customer customer;
}
