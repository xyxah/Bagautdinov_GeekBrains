package lesson6_advanced_oop;

public class Cat extends Animal{
    String color;
    int count;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void catInfo() {
        System.out.println("Кот имя: " + name + " цвет: " + color);
    }

    public void run(int distance){
        if (distance <= 200) System.out.println(name + " пробежал " + distance + " м.");
        else System.out.println(name + " не смог пробежать данное расстояние.");
    }

    public void swim(int distance){
        System.out.println(name + " не умеет плавать.");
    }

    public void catsCount(){
        System.out.println("Количество котов: " + count);
    }



}