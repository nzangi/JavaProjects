package genericsexampleone;

public class Animal <T> {
    private  int animalAge;
    private String animalName;

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalClass(Class<T> animalClass) {
        this.animalClass = animalClass;
    }

    private Class<T> animalClass;

    public Animal(int animalAge, String animalName,Class<T> animalClass){
        this.animalAge = animalAge;
        this.animalName = animalName;
        this.animalClass=animalClass;
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
