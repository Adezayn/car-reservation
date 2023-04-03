package main.java.cars;

import java.util.ArrayList;
import java.util.Map;

public class DataSource {
//    this will serve as db - CARS table
   private static ArrayList<Car> cars = new ArrayList<Car>();

   public static void addCar (Car car) {
       cars.add(car);
       System.out.println(cars + " ::: cars list");
   }

    public static void main(String ...args){
        Car car1 = new Car(1, "Toyota", "2013", "petrol", "camry", TRANSMISSIONTYPE.AUTOMATIC,
                4, true, false, 20.00);
        Car car2 = new Car(2,"Hyundai", "2010", "petrol", "i30", TRANSMISSIONTYPE.MANUAL,
                5, true, false, 21.45);
        Car car3 = new Car(3,"Eicher Motors", "2010", "diesel", "Pick up", TRANSMISSIONTYPE.MANUAL,
                2, false, false, 35.50);
        Car car4 = new Car(4,"Fiat", "2018", "petrol", "500", TRANSMISSIONTYPE.AUTOMATIC,
                4, false, false, 15.10);
        Car car5 = new Car(5,"Toyota", "2018", "diesel", "camry", TRANSMISSIONTYPE.AUTOMATIC,
                5, true, false, 30.00);

        DataSource.cars.add(car1);
        DataSource.cars.add(car2);
        DataSource.cars.add(car3);
        DataSource.cars.add(car4);
        DataSource.cars.add(car5);

        System.out.println(DataSource.cars);



    }

}
