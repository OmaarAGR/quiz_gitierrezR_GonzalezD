package com.quiz.quiz_GitierrezR_GonzalezD.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TruckResponse {

    private Long id;
    private String trucks;
    private String brand;
    private Double capacity;
    private String color;
    private String plate;

    @JsonProperty("user_driver")
    private String userDriver;

    public TruckResponse() {
    }

    public TruckResponse(Long id, String trucks, String brand, Double capacity, String color, String plate, String userDriver) {
        this.id = id;
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
