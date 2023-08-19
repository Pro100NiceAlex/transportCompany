package com.task.transport.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @Column(name = "statenumber")
    private String stateNumber; // гос. номер
    @Column(name = "brand")
    private String brand; // марка ТС
    @Column(name = "model")
    private String model; // модель ТС
    @Column(name = "category")
    private String category; // категория ТС
    @Column(name = "trailer")
    private Boolean trailer; // наличие трейлера
    @Column(name = "yearrelease")
    private String yearRelease; // год выпуска
    @Column(name = "vehicletype")
    private String vehicleType; // тип ТС
    public Transport(String stateNumber, String brand, String model, String category, Boolean trailer, String yearRelease, String vehicleType) {
        this.stateNumber = stateNumber;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.trailer = trailer;
        this.yearRelease = yearRelease;
        this.vehicleType = vehicleType;
    }
    public Transport() {
    }
    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }
    public String getStateNumber() {
        return stateNumber;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setTrailer(Boolean trailer) {
        this.trailer = trailer;
    }
    public Boolean getTrailer() {
        return trailer;
    }
    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }
    public String getYearRelease() {
        return yearRelease;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleType() {
        return vehicleType;
    }
}
