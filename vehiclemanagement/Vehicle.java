package vehiclemanagement;

import java.util.Date;

public abstract class Vehicle {
    private String vehicleName,vehicleModel;
    private double vehicleBuyingPrice;
    private Date date;
    public Vehicle(String vehicleName,String vehicleModel, double vehicleBuyingPrice){
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehicleBuyingPrice = vehicleBuyingPrice;
        date = new Date();
    }


    public abstract void  addVehicle();
    public abstract void removeVehicle();

    public abstract String toString();

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public double getVehicleBuyingPrice() {
        return vehicleBuyingPrice;
    }

    public Date getDate() {
        return date;
    }
}
