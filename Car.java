public class Car extends Vehicle {
    private int seats;
    public Car(String vehicleId, String brand, String model,  double rentPerDay, int seats) {
        super(vehicleId, brand, model, rentPerDay);
        this.seats = seats;
    }
    public void displayVehicle() {   System.out.println("ID: " + vehicleId +" | Car: " + brand + " " + model +" | Seats: " + seats +" | Rent/Day: ₹" + rentPerDay +" | Status: " + (available ? "Available" : "Rented") );
    }
}