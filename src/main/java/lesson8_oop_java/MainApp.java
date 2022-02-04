package lesson8_oop_java;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Участники:");
        Object[] members = new Object[3];
        members[0] = new Cat("Снежок", 100, 6);
        members[1] = new Human("Сергей", 50, 4);
        members[2] = new Robot("Терминатор", 200, 10);

        for (Object member : members) System.out.println(member.toString());

        System.out.println("\nПрепятствия:");
        Object[] obstacles = new Object[4];
        obstacles[0] = new Wall(1, 4);
        obstacles[1] = new Treadmill(1,100);
        obstacles[2] = new Wall(2, 7);
        obstacles[3] = new Treadmill(2,150);

        for (Object obstacle : obstacles) System.out.println(obstacle.toString());

        System.out.println("\nРезультаты:");
        for (int i = 0; i < members.length; i++){
            System.out.println();
            for (int j = 0; j < obstacles.length; j++){
                members[i].equals(obstacles[j]);
            }
        }

    }

}
