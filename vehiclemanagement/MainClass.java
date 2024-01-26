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

    public static ArrayList<VehicleCar> runAddVehicle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter type of vehicle to add. Press 1 for Car, 2 for Lorry: ");
                int vehicleChoice = scanner.nextInt();
                if (vehicleChoice == 1) {
                    ArrayList<VehicleCar> vehicleAddCars = addVehicle(vehicleChoice);
                    removeVehicle(vehicleAddCars);
                    return vehicleAddCars;

                } else if (vehicleChoice == 2) {
                    ArrayList<VehicleCar> vehicleAddLorry = addVehicle(vehicleChoice);
                    removeVehicle(vehicleAddLorry);
                    return vehicleAddLorry;
                } else {
                    System.out.println("Invalid output");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }
    }
    //This method will be responsible for adding vehicle from arrayList

    public static ArrayList<VehicleCar> addVehicle(int vehicleChoice) {
        Scanner scanner = new Scanner(System.in);
        String carName;
        String carModel;
        double carBuyingPrice;
        ArrayList<VehicleCar> vehicleAddCars = new ArrayList<>();
        ArrayList<VehicleLorry> vehicleAddLorries = new ArrayList<>();
        String vehicleName;
        if (vehicleChoice==1){
            vehicleName = "car";
        }else {
            vehicleName = "lorry";
        }
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
            if (vehicleChoice ==1){
                VehicleCar vehicleCar = new VehicleCar(vehicleId,carName, carModel, carBuyingPrice);
                vehicleAddCars.add(vehicleCar);
            }else {
                VehicleLorry vehicleLorry = new VehicleLorry(vehicleId,carName, carModel, carBuyingPrice);
                vehicleAddLorries.add(vehicleLorry);
            }

        }

        if (vehicleChoice==1){
            System.out.println();
            System.out.println("Printing the Added Car Details: ");
            for (VehicleCar vehicleCar : vehicleAddCars) {
                System.out.println();
                System.out.println(vehicleCar);
            }
        }else {
            System.out.println();
            System.out.println("Printing the Added Lorry Details: ");
            for (VehicleLorry vehicleLorry : vehicleAddLorries ) {
                System.out.println();
                System.out.println(vehicleLorry);
            }
        }
        return vehicleAddCars;

    }
    //This method will be responsible for removing vehicle from list

    public static void removeVehicle(ArrayList<VehicleCar> vehicleAddCars){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the car you want to remove, to remove car press 1, \n" +
                "to remove lorry press 2: ");
        int vehicleToRemove = scanner.nextInt();
        if (vehicleToRemove==1){
            for (VehicleCar vehicleCar: vehicleAddCars){
                System.out.println(vehicleCar);
            }
        }
    }
}
