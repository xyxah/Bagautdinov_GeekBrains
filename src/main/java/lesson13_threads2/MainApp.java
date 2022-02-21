package lesson13_threads2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainApp {
    public static final int CARS_COUNT = 4;
    public static int WINNERS = 0;
    public static final CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT + 1);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        try{
            int readyCarCount = barrier.getNumberWaiting();

            while (readyCarCount != CARS_COUNT){
                Thread.sleep(300);
                readyCarCount = barrier.getNumberWaiting();
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            barrier.await();
        }
        catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }

        try{
            int finishCarCount = barrier.getNumberWaiting();

            while (finishCarCount != CARS_COUNT){
                Thread.sleep(50);
                finishCarCount = barrier.getNumberWaiting();

                WINNERS = finishCarCount;
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            barrier.await();
        }
        catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }
}

