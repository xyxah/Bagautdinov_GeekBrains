package lesson13_threads2;

import static lesson13_threads2.MainApp.WINNERS;
import static lesson13_threads2.MainApp.barrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (WINNERS == 0) System.out.println(this.name + " ПОБЕДИТЕЛЬ!!!");

            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
