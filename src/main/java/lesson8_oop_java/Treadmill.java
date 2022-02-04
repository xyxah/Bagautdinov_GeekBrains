package lesson8_oop_java;

public class Treadmill {

    private int number;
    int length;

    public Treadmill(int number, int length) {
        this.number = number;
        this.length = length;
    }

    @Override
    public String toString(){
        return "Беговая дорожка № " + number + "  Длина: " + length + " м.";
    }
}
