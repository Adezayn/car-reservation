package main.java.cars;

import java.time.Year;

enum TRANSMISSIONTYPE {
    AUTOMATIC, MANUAL
}
public class Car {
    @Override
    public String toString() {
        return "Car{" +
                 id +
                ". name='" + name + '\'' +
                ", yearMade='" + yearMade + '\'' +
                ",\n fuelType='" + fuelType + '\'' +
                ", model='" + model + '\'' +
                ", transmissionType=" + transmissionType +
                ",\n passangersCapacity=" + passangersCapacity +
                ", isAC=" + isAC +
                ", isBooked=" + isBooked +
                ", costOfRentalPerHour=" + costOfRentalPerHour +
                '}';
    }

    private int id;
    private String name;
    private String yearMade;
    private String fuelType;
    private String model;
    private TRANSMISSIONTYPE transmissionType;
    private int passangersCapacity;
    private boolean isAC;
    private boolean isBooked;
    private double costOfRentalPerHour;

    public Car(int id, String name,String yearMade, String fuelType, String model,
               TRANSMISSIONTYPE transmissionType, int passangersCapacity, boolean isAC,
               boolean booked, double costOfRentalPerHour ){
                    setId(id);
                    setName(name);
                    setYearMade(yearMade);
                    setFuelType(fuelType);
                    setModel(model);
                    setTransmissionType(transmissionType);
                    setPassangersCapacity(passangersCapacity);
                    setAC(isAC);
                    setBooked(booked);
                    setCostOfRentalPerHour(costOfRentalPerHour);

               }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearMade() {
        return yearMade;
    }

    public void setYearMade(String yearMade) {
        this.yearMade = yearMade;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TRANSMISSIONTYPE getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TRANSMISSIONTYPE transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getPassangersCapacity() {
        return passangersCapacity;
    }

    public void setPassangersCapacity(int passangersCapacity) {
        this.passangersCapacity = passangersCapacity;
    }

    public boolean isAC() {
        return isAC;
    }

    public void setAC(boolean AC) {
        isAC = AC;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getCostOfRentalPerHour() {
        return costOfRentalPerHour;
    }

    public void setCostOfRentalPerHour(double costOfRentalPerHour) {
        this.costOfRentalPerHour = costOfRentalPerHour;
    }
}
