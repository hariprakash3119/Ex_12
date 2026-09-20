public class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double totalCost;
    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.totalCost = vehicle.getRentPerDay() * days;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void displayRental() {
        System.out.println("--------------------------------");
        System.out.println("Customer : " + customer.getName());
        System.out.println("Phone    : " + customer.getPhone());
        System.out.println("Vehicle  : " + vehicle.getVehicleId());
        System.out.println("Days     : " + days);
        System.out.println("Total    : ₹" + totalCost);
        System.out.println("--------------------------------");
    }
}