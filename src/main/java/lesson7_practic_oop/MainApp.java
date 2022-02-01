package lesson7_practic_oop;

public class MainApp {

    public static void main(String[] args) {

        Plate plate = new Plate(25);
        plate.info();

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Снежок", 10, false);
        cats[1] = new Cat("Пушок", 15, false);
        cats[2] = new Cat("Барсик", 5, false);

        for (Cat value : cats) value.eat(plate);
        for (Cat value : cats) value.info();

        plate.info();
        plate.addFood(5);
        plate.info();

        cats[2].eat(plate);
        cats[2].info();

    }
}


