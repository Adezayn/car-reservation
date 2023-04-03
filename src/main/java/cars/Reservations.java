package main.java.cars;

import java.time.LocalDate;


enum RENTALSTTAUS{
    CANCELLED, RENTAL, OPEN
}

public class Reservations {
    private int id;
    private Customer customer;
    private Car car;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
    private int totalUsageDays;
    private RENTALSTTAUS status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public int getTotalUsageDays() {
        return totalUsageDays;
    }

    public void setTotalUsageDays(int totalUsageDays) {
        this.totalUsageDays = totalUsageDays;
    }

    public RENTALSTTAUS getStatus() {
        return status;
    }

    public void setStatus(RENTALSTTAUS status) {
        this.status = status;
    }
}
