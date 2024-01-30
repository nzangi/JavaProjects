package genericsexampleone;

public class MainClass {
    public static void main(String[] args) {
//        AnimalCat animalCat = new AnimalCat(12,"First Cat");
//        animalCat.print();
//        AnimalDog animalDog = new AnimalDog(32,"First Dog");
//        animalDog.print();
        Animal<AnimalDog> animal = new Animal<>(12,"First Dog");
        animal.printSpecificAnimal(animal);
    }
}
