public class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double rentPerDay;
    protected boolean available;
    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public double getRentPerDay() {
        return rentPerDay;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void displayVehicle() {
        System.out.println(  "ID: " + vehicleId +  " | Brand: " + brand + " | Model: " + model + " | Rent/Day: ₹" + rentPerDay + " | Status: " + (available ? "Available" : "Rented")   );
    }
}