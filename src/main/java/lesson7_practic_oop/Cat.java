package lesson7_practic_oop;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public void info(){
        System.out.println("Кот: " + name + "  Аппетит: " + appetite + "  Сытость: " + satiety);
    }
}
