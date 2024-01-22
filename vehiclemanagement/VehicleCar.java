package vehiclemanagement;

public class VehicleCar extends Vehicle{

    public VehicleCar(String vehicleName, String vehicleModel, double vehicleBuyingPrice) {
        super(vehicleName, vehicleModel, vehicleBuyingPrice);
    }

    @Override
    public void addVehicle() {


    }

    @Override
    public void removeVehicle() {

    }

    @Override
    public String toString() {
        return "The vehicle Name is "+this.getVehicleName()+" and the model " +
                "is "+this.getVehicleModel()+ "\nThe buying price of teh car is :USD  " +
                ""+this.getVehicleBuyingPrice()+"\nCreation Date : " +this.getDate();
    }
}
