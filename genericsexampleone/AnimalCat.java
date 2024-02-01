package genericsexampleone;

public class AnimalCat extends Animal<AnimalCat>{
    public AnimalCat(int animalAge, String animalName) {
        super(animalAge, animalName,AnimalCat.class);
    }
    public void print(){
        printSpecificAnimal(this);
    }
}
