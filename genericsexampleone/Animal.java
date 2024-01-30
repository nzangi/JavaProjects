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
    public void printSpecificAnimal(Animal<T> animal){
        System.out.println("The "+animal.getClass().getSimpleName()+" name is " +
                ""+animal.getAnimalName() + " and "+animal.getClass().getSimpleName().toLowerCase()+" " +
                "and "+animal.getAnimalAge());

    }
}
