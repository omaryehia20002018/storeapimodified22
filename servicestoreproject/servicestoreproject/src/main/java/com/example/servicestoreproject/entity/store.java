package com.example.servicestoreproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
    //@SequenceGenerator(name = "store_seq", sequenceName = "store_seq", allocationSize = 1)
    //@Column(name = "store_id")
    private int storeid;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;


}
