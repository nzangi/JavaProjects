package genericsexampleone;

public class Animal <T> {
    private  int animalAge;
    private String animalName;
    public Animal(int animalAge,String animalName){
        this.animalAge = animalAge;
        this.animalName = animalName;
    }
    public int getAnimalAge(){
        return animalAge;
    }
    public String getAnimalName(){
        return animalName;
    }
    public String printSpecificAnimal(Animal<T> animal){
        return "The "+animal.getClass().getSimpleName()+" name is " +
                ""+animal.getAnimalName() + " and "+animal.getClass().getSimpleName().toLowerCase()+" " +
                "and "+animal.getAnimalAge();
    }
}
