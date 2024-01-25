package vehiclemanagement;

public class VehicleCar extends Vehicle{
    private int carIdNumber;

    public VehicleCar(int carIdNumber,String vehicleName, String vehicleModel, double vehicleBuyingPrice) {
        super(vehicleName, vehicleModel, vehicleBuyingPrice);
        this.carIdNumber= carIdNumber;
    }

    @Override
    public void addVehicle() {


    }

    @Override
    public void removeVehicle() {

    }

    @Override
    public String toString() {
        return "Car id is "+carIdNumber+" , the vehicle Name is "+this.getVehicleName()+" and the model " +
                "is "+this.getVehicleModel()+ "\nThe buying price of teh car is :USD  " +
                ""+this.getVehicleBuyingPrice()+"\nCreation Date : " +this.getDate();
    }
}
