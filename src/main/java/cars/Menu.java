package main.java.cars;

//import javax.security.auth.login.LoginException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Menu menu = new Menu(); // Create a new Menu object
        Customer customer; // Initialize the customer object to null
        System.out.println("Welcome to theTEE car rental system \n");

        customer = menu.validateCustomer();

        if(customer == null){
            System.out.println("You are not registered!");
            System.exit(0); // Terminate the Java Virtual Machine if the customer is not valid
        }

        // Show the reservation menu for the validated customer
        menu.showReservationMenu(customer);

        // Close the scanner object
        menu.scanner.close();
    }


//    ------------------------------------ CUSTOMERS METHODS -----------------------------------------------
    private Customer validateCustomer(){
        int selection = 0;
        String name;
        String phoneNumber;
        String email;
        Customer customer;
        System.out.println("Are you a registered customer ?\n");

      while(selection <= 3) {
          System.out.println("-----------------------------");
          System.out.println("1: Yes");
          System.out.println("2: No");
          System.out.println("3: Exit");
          System.out.println("-----------------------------");

          selection = scanner.nextInt();

          switch (selection) {
              case 1:
                  try{
                      customer = authenticateUser();
                      return customer;
                  }catch(Exception e){
                      System.out.println(e.getMessage());
                      break;
                  }
              case 2:
                  System.out.println("Let us get you registered...\n");
                  System.out.println("What is your first name?");
                  name = scanner.next();
                  System.out.println("What is your phoneNumber?");
                  phoneNumber = scanner.next();
                  System.out.println("What is your email address?");
                  email = scanner.next();

               customer =  registerCustomer(name, phoneNumber, email);
                  return customer;

              case 3:
                  System.out.println("Exiting the system. Goodbye!");
                  return null;

              default:
                  System.out.println("Invalid option. Please try again");
                 break;
          }
      }
        return null;
    }

    private Customer authenticateUser() {
        System.out.println("Please enter your first name");
        String username = scanner.next();

        System.out.println("Please enter your email");
        String email = scanner.next();

        Customer customer;

        if(
                DataSource.getCustomers().stream().anyMatch(i -> email.equals(i.getEmail())) &&
                        DataSource.getCustomers().stream().anyMatch(i -> username.equals(i.getName()))
        ){
            customer =  DataSource.getCustomers().stream().filter( i -> email.equals(i.getEmail() ) ).findFirst().get();
            System.out.println("Hello " + customer.getName());
            return customer;

        }
        return null;
//           throw new Exception("You are not registered on the portal. Exit and try again.");

    }

    private Customer registerCustomer( String name, String phoneNumber, String email){
        int id = (DataSource.getCustomers().size()) + 1;
        Customer customer = new Customer(id, name, phoneNumber, email);
        DataSource.getCustomers().add(customer);
        DataSource.getCustomers().forEach(i -> System.out.println(i.toString()));
        System.out.println("You have been successfully registered");
        return customer;
    }

    //    ------------------------------------ CUSTOMERS METHODS (END)-----------------------------------------------



    //    ------------------------------------ RESERVATIONS METHODS -----------------------------------------------

    private void showReservationMenu(Customer customer) {
        int selection = 0;

        while (selection != 4) {
            System.out.println("================================================");
            System.out.println("Please select one of the following options: ");
            System.out.println("1: Book a reservation");
            System.out.println("2: Return");
            System.out.println("3: Cancel");
            System.out.println("4: Exit");
            System.out.println("================================================");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    bookReservation(customer);
                    break;
                case 2:
                    returnCar(customer);
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        }
    }


    private void bookReservation(Customer customer) {
        System.out.println("These are the list of available cars \n");

//        Filtered out booked cars (method returns car that isBooked == false.
        DataSource.getCars().stream().filter(i-> !(i.isBooked())).forEach(i -> System.out.println(i));

        System.out.println("\nWhich car would you love to book? Pick id number: eg 1 \n");
        int selectedCarID = scanner.nextInt();

        Car selectedCar =  getSelectedCar(selectedCarID);

        if(selectedCar.isBooked()){
            System.out.println("Car already booked. Kindly check another option.");
            return;
        }

        System.out.println("\nHow many days do you want to rent it? If to be returned in 24hours - 1day");
        long daysOfRentage = scanner.nextLong();

        try{

            LocalDate pickUpDate = LocalDate.now();
            LocalDate dropOffDate = pickUpDate.plusDays(daysOfRentage);
            Double costPrice = generateCost(daysOfRentage, selectedCar);

            long reservationsID = DataSource.getReservations().size();
            long newReservationID = reservationsID + 1;


            Reservations reservation = new Reservations(newReservationID,customer, selectedCar,
                    pickUpDate, dropOffDate, (int) daysOfRentage, RENTAL_STATUS.RENTED);

            DataSource.getReservations().put(newReservationID,reservation);
            DataSource.getCars().stream().map(i-> {
                if(i.equals(selectedCar)){
                    i.setBooked(true);
                }
                return i;
            }).collect(Collectors.toList());

            DataSource.getReservations().forEach(((k,v)->v.toString()));
            System.out.println("\n" + DataSource.getReservations().toString() + " in book reservation method");
            System.out.println("Congratulation!🥳 \nYou have successfully booked a reservation. " +
                    "This costs " + "$" + costPrice + "." + " It is to be returned on "
                    + dropOffDate + ".");

        }
        catch( Exception e){
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
        }
    }

    private void returnCar(Customer customer) {
        System.out.println("============================================================================ \n");
       Reservations bookedReservation = DataSource.getReservations().values().stream().filter(i->customer.equals(i.getCustomer())).findFirst().get();


//        boolean customerBooked = .anyMatch(i -> i.getCustomer() == customer);
//        System.out.println(bookedReservation + " return car ");

        if(bookedReservation != null){
            DataSource.getReservations().values().stream().map(i -> {
               if(i.getId() == bookedReservation.getId()){
                   i.getCar().setBooked(false);
                   i.setStatus(RENTAL_STATUS.RETURNED);

               }
                    return i;
                    }
            ).collect(Collectors.toList());
            DataSource.getReservations().forEach((k,v)-> System.out.println(v));
            DataSource.getCars().forEach(i-> System.out.println(i));
        }else{
            System.out.println("You have not booked any reservation!");
        }
        // code for returning a car
    }

    private void cancelReservation() {
        // code for cancelling a reservation
    }

    //  ------------------------------------ RESERVATIONS METHODS (END)----------------------------------



    //    --------------------------- UTILITY METHODS ------------------------------------------------
    private Car getSelectedCar(int carID){
        Car reservedCar = DataSource.getCars().stream().filter(i-> carID == i.getId()).findFirst().get();
        return reservedCar;
    }

    private Double generateCost(long daysOfRentage, Car car){
         Double costPrice = daysOfRentage * car.getCostOfRentalPerHour() * 24;
         return costPrice;
    }

    //   --------------------------- UTILITY METHODS (END)------------------------------------------------
}
