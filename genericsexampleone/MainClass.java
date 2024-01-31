package genericsexampleone;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<AnimalCat> animalCats = addAnimal(AnimalCat.class);
//        ArrayList<String> animalCat = addAnimal(AnimalCat.class);

        for (Animal<AnimalCat> animalCat:animalCats){
            System.out.println(animalCat.printSpecificAnimal(animalCat));
        }
//        addAnimal()
    }
    public static <T extends Animal<T>> ArrayList<T> addAnimal(Class<T> animalClass){
        Scanner scanner = new Scanner(System.in);
        ArrayList<T> animalList = new ArrayList<>();
        String animalName;
        int animalAge;
        System.out.print("Enter the number of animals to add in the list: ");
        int numberOfAnimals= scanner.nextInt();
        for (int i =0;i < numberOfAnimals;i++){
            scanner.nextLine();
            System.out.print("Enter the animal Name:");
            animalName = scanner.nextLine();
            System.out.print("Enter the animal Age:");
            animalAge = scanner.nextInt();

            if(animalClass== AnimalCat.class){
                Animal<AnimalCat> animalCat = new Animal<>(animalAge,animalName);
                animalList.add(animalClass.cast(animalCat));
            }else {
                Animal<AnimalDog> animalDog = new Animal<>(animalAge,animalName);
                animalList.add(animalClass.cast(animalDog));
            }
        }

        return animalList;
    }
}
