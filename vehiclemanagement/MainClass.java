package vehiclemanagement;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter type of vehicle to add. Press 1 for Car, 2 for Lorry: ");
            int vehicleChoice = scanner.nextInt();
            if (vehicleChoice == 1){
                addVehicleCar();

            } else if (vehicleChoice == 2) {
                addVehicleLorry();
            }else {
                System.out.println("Invalid output");
            }
            System.out.print("Do you want to exit the program,Press 1 to exit,2 to continue: ");
            int exitMainProgram = scanner.nextInt();
            if (exitMainProgram == 1){
                System.out.println("Existing the main program....");
                break;
            }else if (exitMainProgram==2){
                continue;
            }
            else {
                System.out.println("Invalid output");
            }
        }

    }
    public static void addVehicleCar(){
        VehicleCar vehicleCar = new VehicleCar("Toyota","Harrier",1000);
        System.out.println(vehicleCar);
    }
    public static void addVehicleLorry(){
        VehicleLorry vehicleLorry = new VehicleLorry("Toyota Lorry","Harrier Lorry",3000);
        System.out.println(vehicleLorry);
    }
}
