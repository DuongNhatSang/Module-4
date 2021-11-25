package com.codegym.dto;

import com.codegym.model.RentType;
import com.codegym.model.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServiceDTO {
    private int serviceId;

    @NotBlank(message = "không được để trống")
    private String serviceName;

    @NotNull(message = "không được để trống")
    @Min(value = 20, message = "Phải là số dương")
    private int serviceArea;

    @NotNull(message = "không được để trống")
    @Min(value = 1, message = "Phải là số dương")
    private double serviceCost;

    @NotNull(message = "không được để trống")
    @Min(value = 1, message = "Phải là số dương")
    private int serviceMaxPeople;

    private int rentType;
    private int serviceType;

    @NotBlank(message = "không được để trống")
    private String standardRoom;

    @NotBlank(message = "không được để trống")
    private String descriptionOther;

    @NotNull(message = "không được để trống")
    @Min(value = 50, message = "Phải là số dương")
    private double poolArea;

    @NotNull(message = "không được để trống")
    @Min(value = 1, message = "Phải là số dương")
    private int numberOfFloors;

    public ServiceDTO() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
