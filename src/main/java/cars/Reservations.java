package main.java.cars;

import java.time.LocalDate;


enum RENTAL_STATUS{
    CANCELLED, RENTED, OPEN, RETURNED
}

public class Reservations {
    private long id;
    private Customer customer;
    private Car car;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
    private long totalUsageDays;

    public Reservations(long id, Customer customer, Car car, LocalDate pickupDate, LocalDate dropoffDate, int totalUsageDays, RENTAL_STATUS status) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.totalUsageDays = totalUsageDays;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", customer=" + customer +
                ",\n car=" + car +
                ",\n pickupDate=" + pickupDate +
                ",dropoffDate=" + dropoffDate +
                ",totalUsageDays=" + totalUsageDays +
                ", status=" + status +
                '}' + "\n";
    }

    private RENTAL_STATUS status;

    public long getId() {
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

    public long getTotalUsageDays() {
        return totalUsageDays;
    }

    public void setTotalUsageDays(int totalUsageDays) {
        this.totalUsageDays = totalUsageDays;
    }

    public RENTAL_STATUS getStatus() {
        return status;
    }

    public void setStatus(RENTAL_STATUS status) {
        this.status = status;
    }
}
