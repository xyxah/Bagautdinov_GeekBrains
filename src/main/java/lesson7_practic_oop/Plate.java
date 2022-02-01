package lesson7_practic_oop;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        else {
            System.out.println("Еды в тарелке не хватило коту");
            return false;
        }
    }

    public void info() {
        System.out.println("Тарелка: " + food);
    }

    public void addFood(int n){
        food += n;
    }
}
