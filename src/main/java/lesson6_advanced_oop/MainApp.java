package lesson6_advanced_oop;

public class MainApp {

    static int cats = 0;
    static int dogs = 0;
    static int animals = 0;

    public static void main(String[] args) {

        Animal animal = new Animal("Ракета");
        animal.animalInfo();
        animal.run();
        animals = animal.addToCount(animals);
        System.out.println();

        Cat cat = new Cat("Пушистик", "Серый");
        cat.catInfo();
        cat.run(150);
        cat.run(210);
        cat.swim(10);
        cats = cat.addToCount(cats);
        System.out.println();

        Dog dog = new Dog("Шарик", "Черный");
        dog.dogInfo();
        dog.run(480);
        dog.run(600);
        dog.swim(8);
        dog.swim(15);
        dogs = dog.addToCount(dogs);
        System.out.println();

        allAnimals(animals, dogs, cats);
    }

    public static void allAnimals(int animals, int dogs, int cats){
        System.out.println("Всего животных = " + animals);
        System.out.println("Всего котов = " + cats);
        System.out.println("Всего собак = " + dogs);
    }

}
