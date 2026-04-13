package com.quiz.quiz_GitierrezR_GonzalezD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trucks;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private Double capacity;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(name = "user_driver", nullable = false)
    private String userDriver;

    public Truck() {
    }

    public Truck(String trucks, String brand, Double capacity, String color, String plate, String userDriver) {
        this.trucks = trucks;
        this.brand = brand;
        this.capacity = capacity;
        this.color = color;
        this.plate = plate;
        this.userDriver = userDriver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrucks() {
        return trucks;
    }

    public void setTrucks(String trucks) {
        this.trucks = trucks;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getUserDriver() {
        return userDriver;
    }

    public void setUserDriver(String userDriver) {
        this.userDriver = userDriver;
    }
}
