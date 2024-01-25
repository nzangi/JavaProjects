package vehiclemanagement;

public class VehicleLorry extends Vehicle{
    private int lorryIdNumber;

    public VehicleLorry(int lorryIdNumber,String vehicleName, String vehicleModel, double vehicleBuyingPrice) {
        super(vehicleName, vehicleModel, vehicleBuyingPrice);
        this.lorryIdNumber = lorryIdNumber;
    }

    @Override
    public void addVehicle() {

    }

    @Override
    public void removeVehicle() {

    }

    public String toString() {
        return "The Lorry id is "+lorryIdNumber+", the lorry Name is "+this.getVehicleName()+" and the model " +
                "is "+this.getVehicleModel()+ "\nThe buying price of teh car is :USD  " +
                ""+this.getVehicleBuyingPrice()+"\nCreation Date: " +this.getDate();
    }
}
