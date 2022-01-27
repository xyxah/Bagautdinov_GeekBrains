package lesson6_advanced_oop;

public class Dog extends Animal{

    String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void dogInfo() {
        System.out.println("Собака имя: " + name + " цвет: " + color);
    }

    public void run(int distance){
        if (distance <= 500) System.out.println(name + " пробежал " + distance + " м.");
        else System.out.println(name + " не смог пробежать данное расстояние.");
    }

    public void swim(int distance){
        if (distance <= 10) System.out.println(name + " проплыл " + distance + " м.");
        else System.out.println(name + " не смог проплыть данное расстояние.");
    }

}
