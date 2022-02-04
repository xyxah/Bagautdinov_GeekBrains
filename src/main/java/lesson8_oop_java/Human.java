package lesson8_oop_java;

public class Human {

    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public String toString(){
        return "Человек: " + name + "  Макс. бег: " + maxRun + "  Макс. прыжок: " + maxJump;
    }

    @Override
    public boolean equals(Object o){

        if (o.getClass() == Wall.class){
            Wall w = (Wall) o;
            if (w.height > maxJump) System.out.println("Человек: " + name + " не смог перепрыгнуть данную высоту.");
            else System.out.println("Человек: " + name + " смог перепрыгнуть данную высоту.");
            return true;
        }

        else if (o.getClass() == Treadmill.class){
            Treadmill t = (Treadmill) o;
            if (t.length > maxRun) System.out.println("Человек: " + name + " не смог пробежать данное расстояние.");
            else System.out.println("Человек: " + name + " смог пробежать данное расстояние.");
            return true;
        }

        else return false;
    }
}
