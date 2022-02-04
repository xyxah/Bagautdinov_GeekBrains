package lesson8_oop_java;

public class Wall {

    private int number;
    int height;

    public Wall(int number, int height) {
        this.number = number;
        this.height = height;
    }

    @Override
    public String toString(){
        return "Стена № " + number + "  Высота: " + height + " м.";
    }
}
