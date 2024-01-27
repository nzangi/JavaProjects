package vehiclemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runAddVehicle();
        while (true) {
            try {
                System.out.print("Do you want to exit the program,Press 1 to exit,2 to continue: ");
                int exitMainProgram = scanner.nextInt();
                if (exitMainProgram == 1) {
                    System.out.println("Existing the main program....");
                    break;
                } else if (exitMainProgram == 2) {
                    runAddVehicle();
                } else {
                    System.out.println("Invalid output");
                }
            }catch (Exception e){
                System.out.println("Invalid Input");
                scanner.nextLine();
            }

        }

    }
    //This method will be responsible for running vehicle from arrayList to add vehicles in list
    // and also remove them by passing arguments

    public static <T extends Vehicle> ArrayList<T> runAddVehicle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter type of vehicle to add. Press 1 for Car, 2 for Lorry: ");
                int vehicleChoice = scanner.nextInt();
                if (vehicleChoice == 1) {
                    ArrayList<VehicleCar> vehicleAddCars = addVehicle(VehicleCar.class);
                    removeVehicle(vehicleAddCars);
//                    return new ArrayList<>(vehicleAddCars);
                    return (ArrayList<T>) vehicleAddCars;

                } else if (vehicleChoice == 2) {
                    ArrayList<VehicleLorry> vehicleAddLorry = addVehicle(VehicleLorry.class);
                    removeVehicle(vehicleAddLorry);
                    return (ArrayList<T>) vehicleAddLorry;
                } else {
                    System.out.println("Invalid output");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }
    }
    //This method will be responsible for adding vehicle from arrayList

    public static <T extends Vehicle> ArrayList<T> addVehicle(Class<T> vehicleClass) {
        Scanner scanner = new Scanner(System.in);
        String carName;
        String carModel;
        double carBuyingPrice;

        ArrayList<T> vehicleList = new ArrayList<>();
        String vehicleName = vehicleClass.getSimpleName();
        System.out.print("Enter the number of "+vehicleName+" you want to add: ");
        int numberOfCars = scanner.nextInt();
        int vehicleId = 1;
        for (int i = 0; i < numberOfCars; i++) {
            vehicleId = i+1;
            scanner.nextLine();
            while (true) {
                try {
                    System.out.print("Enter the "+vehicleName+" Name for "+vehicleName+" number " + (i + 1) + " : ");
                    carName = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {

                    System.out.print("Enter the "+vehicleName+" Model for "+vehicleName+" number " + (i + 1) + " : ");
                    carModel = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Enter the "+vehicleName+" Buying price for "+vehicleName+" number " + (i + 1) + " : ");
                    carBuyingPrice = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            try {
                if (vehicleClass ==VehicleCar.class){
                    VehicleCar vehicleCar = new VehicleCar(vehicleId,carName, carModel, carBuyingPrice);
                    vehicleList.add((T) vehicleCar);
                }else if (vehicleClass == VehicleLorry.class){
                    VehicleLorry vehicleLorry = new VehicleLorry(vehicleId,carName, carModel, carBuyingPrice);
                    vehicleList.add((T) vehicleLorry);
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }

        System.out.println();
        System.out.println("Printing the Added " + vehicleName + " Details: ");
        for (T vehicle : vehicleList) {
            System.out.println();
            System.out.println(vehicle);
        }
        return vehicleList;

    }
    //This method will be responsible for removing vehicle from list

    public static <T extends Vehicle> void removeVehicle(ArrayList<T> vehicleList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the car you want to remove, to remove car press 1, \n" +
                "to remove lorry press 2: ");
        int vehicleToRemove = scanner.nextInt();
        if (vehicleToRemove==1){
            for (T vehicle : vehicleList) {
                System.out.println();
                System.out.println(vehicle);
            }
        }
    }
}
