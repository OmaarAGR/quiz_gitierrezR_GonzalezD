package com.quiz.quiz_GitierrezR_GonzalezD.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TruckRequest {

    @NotBlank(message = "El campo trucks es obligatorio")
    private String trucks;

    @NotBlank(message = "El campo brand es obligatorio")
    private String brand;

    @NotNull(message = "El campo capacity es obligatorio")
    @DecimalMin(value = "0.1", message = "La capacidad debe ser mayor a 0")
    private Double capacity;

    @NotBlank(message = "El campo color es obligatorio")
    private String color;

    @NotBlank(message = "El campo plate es obligatorio")
    private String plate;

    @NotBlank(message = "El campo user_driver es obligatorio")
    @JsonProperty("user_driver")
    private String userDriver;

    public TruckRequest() {
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
