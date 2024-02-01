package genericsexampleone;

public class AnimalDog extends Animal<AnimalDog>{
    public AnimalDog(int animalAge, String animalName) {
        super(animalAge, animalName,AnimalDog.class);
    }
    public void print(){
        printSpecificAnimal(this);
    }
}
