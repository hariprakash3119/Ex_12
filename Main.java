import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        vehicles.add(new Car("C101", "Toyota", "Innova", 1500, 7));
        vehicles.add(new Car("C102", "Hyundai", "i20", 1200, 5));
        vehicles.add(new Bike("B101", "Yamaha", "R15", 800, 155));
        vehicles.add(new Bike("B102", "Honda", "Activa", 500, 110));

        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println("      VEHICLE RENTAL SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Vehicles");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. View Rental History");
            System.out.println("6. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        viewVehicles();
                        break;
                    case 2:
                        addVehicle();
                        break;
                    case 3:
                        rentVehicle();
                        break;
                    case 4:
                        returnVehicle();
                        break;
                    case 5:
                        viewRentalHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using Vehicle Rental System!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                choice = 0;
            }
        } while (choice != 6);
        sc.close();
    }
    static void viewVehicles() {
        System.out.println("\n========== VEHICLE LIST ==========");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        for (Vehicle v : vehicles) {
            v.displayVehicle();
        }
    }
    static void addVehicle() {
        System.out.println("\n========== ADD VEHICLE ==========");
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(id)) {
                System.out.println("Vehicle ID already exists!");
                return;
            }
        }
        System.out.print("Enter Brand: ");
        String brand = sc.next();
        System.out.print("Enter Model: ");
        String model = sc.next();
        System.out.print("Enter Rent Per Day: ");
        double rent = sc.nextDouble();
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Choose Vehicle Type: ");
        int type = sc.nextInt();
        if (type == 1) {
            System.out.print("Enter Number of Seats: ");
            int seats = sc.nextInt();
            vehicles.add(new Car(id, brand, model, rent, seats));
            System.out.println("Car added successfully!");
        } else if (type == 2) {
            System.out.print("Enter Engine CC: ");
            int cc = sc.nextInt();
            vehicles.add(new Bike(id, brand, model, rent, cc));
            System.out.println("Bike added successfully!");
        } else {
            System.out.println("Invalid vehicle type!");
        }
    }
   static void rentVehicle() {
        System.out.println("\n========== RENT VEHICLE ==========");

        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();
        Vehicle selectedVehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(id)) {
                selectedVehicle = v;
                break;
            }
        }
        if (selectedVehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }
        if (!selectedVehicle.isAvailable()) {
            System.out.println("Vehicle is already rented!");
            return;
        }
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.next();
        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();
        if (days <= 0) {
            System.out.println("Days must be greater than 0!");
            return;
        }
   Customer customer = new Customer(customerId, name, phone);

        Rental rental = new Rental(selectedVehicle,  customer, days    );
        rentals.add(rental);
        selectedVehicle.setAvailable(false);
        System.out.println("\nVehicle rented successfully!");
        System.out.println("Customer: " + name);
        System.out.println("Vehicle: " + id);
        System.out.println("Number of Days: " + days);
        System.out.println(
                "Total Cost: ₹" +    (selectedVehicle.getRentPerDay() * days)
        );
    }
    static void returnVehicle() {
        System.out.println("\n========== RETURN VEHICLE ==========");
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(id)) {
                if (v.isAvailable()) {
                    System.out.println("This vehicle is not currently rented.");
                } else {
                    v.setAvailable(true);
                    System.out.println( "Vehicle " + id +" returned successfully!" );
                }
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }   static void viewRentalHistory() {

        System.out.println("\n========== RENTAL HISTORY ==========");

        if (rentals.isEmpty()) {
            System.out.println("No rental history available.");
            return;
        }
        for (Rental r : rentals) {
            r.displayRental();
        }
    }
}