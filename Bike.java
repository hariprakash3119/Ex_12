public class Bike extends Vehicle {
    private int engineCC;
    public Bike(String vehicleId, String brand, String model, double rentPerDay, int engineCC) {
        super(vehicleId, brand, model, rentPerDay);
        this.engineCC = engineCC;
    }
    public void displayVehicle() {
        System.out.println( "ID: " + vehicleId + " | Bike: " + brand + " " + model + " | Engine: " + engineCC + "cc" + " | Rent/Day: ₹" + rentPerDay +  " | Status: " + (available ? "Available" : "Rented")        );               
    }
}