package genericsexampleone;

public class AnimalDog extends Animal<AnimalDog>{
    public AnimalDog(int animalAge, String animalName) {
        super(animalAge, animalName);
    }
    public void print(){
        printSpecificAnimal(this);
    }
}
