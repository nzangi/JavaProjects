package vehiclemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter type of vehicle to add. Press 1 for Car, 2 for Lorry: ");
            int vehicleChoice = scanner.nextInt();
            if (vehicleChoice == 1) {
                addVehicleCar();

            } else if (vehicleChoice == 2) {
                addVehicleLorry();
            } else {
                System.out.println("Invalid output");
            }
            System.out.print("Do you want to exit the program,Press 1 to exit,2 to continue: ");
            int exitMainProgram = scanner.nextInt();
            if (exitMainProgram == 1) {
                System.out.println("Existing the main program....");
                break;
            } else if (exitMainProgram == 2) {
                continue;
            } else {
                System.out.println("Invalid output");
            }
        }

    }

    public static void addVehicleCar() {
        Scanner scanner = new Scanner(System.in);
        String carName;
        String carModel;
        double carBuyingPrice;
        ArrayList<VehicleCar> vehicleAddCars = new ArrayList<>();
        System.out.print("Enter the number of cars you want to add: ");
        int numberOfCars = scanner.nextInt();
        for (int i = 0; i < numberOfCars; i++) {
            scanner.nextLine();
            while (true) {
                try {
                    System.out.print("Enter the Car Name for car number " + (i + 1) + " : ");
                    carName = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {

                    System.out.print("Enter the Car Model for car number " + (i + 1) + " : ");
                    carModel = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Enter the Car Buying price for car number " + (i + 1) + " : ");
                    carBuyingPrice = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            VehicleCar vehicleCar = new VehicleCar(carName, carModel, carBuyingPrice);
            vehicleAddCars.add(vehicleCar);

        }
        System.out.println();
        System.out.println("Printing the Added Car Details: ");
        for (VehicleCar vehicleCar : vehicleAddCars) {
            System.out.println();
            System.out.println(vehicleCar);
        }

    }

    public static void addVehicleLorry() {
        Scanner scanner = new Scanner(System.in);
        String lorryName;
        String lorryModel;
        double lorryBuyingPrice;
        ArrayList<VehicleLorry> vehicleAddLorries = new ArrayList<>();
        System.out.print("Enter the number of lorries you want to add: ");
        int numberOfCars = scanner.nextInt();
        for (int i = 0; i < numberOfCars; i++) {
            scanner.nextLine();
            while (true) {
                try {
                    System.out.print("Enter the Lorry Name for Lorry number " + (i + 1) + " : ");
                    lorryName = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {

                    System.out.print("Enter the Lorry Model for Lorry number " + (i + 1) + " : ");
                    lorryModel = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Enter the Lorry Buying price for Lorry number " + (i + 1) + " : ");
                    lorryBuyingPrice = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid data type");
                    scanner.nextLine();
                }
            }
            VehicleLorry vehicleLorry = new VehicleLorry(lorryName, lorryModel, lorryBuyingPrice);
            vehicleAddLorries.add(vehicleLorry);
        }


        System.out.println();
        System.out.println("Printing the Added Lorry Details: ");
        for (VehicleLorry vehicleLorry : vehicleAddLorries ) {
            System.out.println();
            System.out.println(vehicleLorry);
        }

    }
}
