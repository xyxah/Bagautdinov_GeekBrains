package lesson6_advanced_oop;

public class Animal {
    String name;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public void animalInfo() {
        System.out.println("Животное: " + name);
    }

    public void run() {
        System.out.println("Животное подпрыгнуло.");
    }

    public int addToCount(int count){
        return count + 1;
    }
}
