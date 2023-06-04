package ru.car.buycar.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "ls")
    private int ls;

    @Column(name = "toplivo")
    private String toplivo;

    @Column(name = "price")
    private int price;
}
