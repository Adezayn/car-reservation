package main.java.cars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSource {
//    this will serve as db - CARS table
   private static ArrayList<Car> cars = new ArrayList<>();

   static{
       Car car1 = new Car(1, "Toyota", "2013", "petrol", "camry", TRANSMISSIONTYPE.AUTOMATIC,
               4, true, false, 5.00);
       Car car2 = new Car(2,"Hyundai", "2010", "petrol", "i30", TRANSMISSIONTYPE.MANUAL,
               5, true, false, 6.45);
       Car car3 = new Car(3,"Eicher Motors", "2010", "diesel", "Pick up", TRANSMISSIONTYPE.MANUAL,
               2, false, false, 10.50);
       Car car4 = new Car(4,"Fiat", "2018", "petrol", "500", TRANSMISSIONTYPE.AUTOMATIC,
               4, false, false, 3.10);
       Car car5 = new Car(5,"Toyota", "2018", "diesel", "camry", TRANSMISSIONTYPE.AUTOMATIC,
               5, true, false, 8.00);

       DataSource.setCars(car1);
       DataSource.setCars(car2);
       DataSource.setCars(car3);
       DataSource.setCars(car4);
       DataSource.setCars(car5);
   }
    private static ArrayList<Customer> customers = new ArrayList<>();

   static{
       Customer customer1 = new Customer(1, "Mike", "08110013412", "mike100@yahoo.com");
       Customer customer2 = new Customer(2, "Grace", "08052014403", "graceadekoya@yahoo.com");
       Customer customer3 = new Customer(3, "Ellan", "08141291001", "ellan_2@gmail.com");

       DataSource.setCustomers(customer1);
       DataSource.setCustomers(customer2);
       DataSource.setCustomers(customer3);
   }
    private static Map<Long, Reservations> reservations = new HashMap<>();

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static void setCars(Car car) {
        DataSource.cars.add(car);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(Customer customer) {
        DataSource.customers.add(customer);
    }

    public static Map<Long, Reservations> getReservations() {
        return reservations;
    }

    public static void setReservations(Map<Long, Reservations> reservations) {
        DataSource.reservations = reservations;
    }


   public static void addCar (Car car) {
       cars.add(car);
       System.out.println(cars + " ::: cars list");
   }
    public static void addCustomer (Customer customer) {
        customers.add(customer);
        System.out.println(customers + " ::: cars list");
    }

    public static void main(String ...args){


       DataSource.getCars().stream().forEach(i -> System.out.println(i.toString()));
//        System.out.println(DataSource.cars.stream().iterator());

    }

}
