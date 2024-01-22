package vehiclemanagement;

public class VehicleLorry extends Vehicle{
    public VehicleLorry(String vehicleName, String vehicleModel, double vehicleBuyingPrice) {
        super(vehicleName, vehicleModel, vehicleBuyingPrice);
    }

    @Override
    public void addVehicle() {

    }

    @Override
    public void removeVehicle() {

    }

    public String toString() {
        return "The vehicle Name is "+this.getVehicleName()+" and the model " +
                "is "+this.getVehicleModel()+ "\nThe buying price of teh car is :USD  " +
                ""+this.getVehicleBuyingPrice()+"\nCreation Date: " +this.getDate();
    }
}
