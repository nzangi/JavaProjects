package genericsexampleone;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of animal to add,press 1 for cat, 2 for Dog: ");
        int animalTypeChoice = scanner.nextInt();
        if (animalTypeChoice==1){
            ArrayList<Animal<AnimalCat>> animalCats = addAnimal(AnimalCat.class);

            for (Animal<AnimalCat> animalCat:animalCats){
                System.out.println(animalCat.printSpecificAnimal(animalCat));
            }
        }
        else {
            ArrayList<Animal<AnimalDog>> animalDogs = addAnimal(AnimalDog.class);
            for (Animal<AnimalDog> animalDog:animalDogs){
                System.out.println(animalDog.printSpecificAnimal(animalDog));
            }
        }

    }
    public static <T> ArrayList<Animal<T>> addAnimal(Class<T> animalClass){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal<T>> animalList = new ArrayList<>();
        String animalName;
        int animalAge;
        String animalTypeName = animalClass.getSimpleName();
        System.out.print("Enter the number of animals to add in the list: ");
        int numberOfAnimals= scanner.nextInt();
        for (int i =0;i < numberOfAnimals;i++){
            scanner.nextLine();
            System.out.print("Enter the animal "+animalTypeName+" Name:");
            animalName = scanner.nextLine();
            System.out.print("Enter the animal "+animalTypeName+" Age:");
            animalAge = scanner.nextInt();

            Animal<T> animal = new Animal<>(animalAge, animalName,animalClass);
            animalList.add(animal);
        }

        return animalList;
    }
}
