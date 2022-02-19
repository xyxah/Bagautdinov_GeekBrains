package lesson12_threads1;

import java.util.Arrays;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        threadMassive1();
        threadMassive2();
    }

    public static void threadMassive1(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("First method = " + (System.currentTimeMillis() - a));
    }

    public static void threadMassive2() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        System.arraycopy(arr,0,arr1,0, HALF);
        System.arraycopy(arr,HALF,arr2,0,HALF);

        MyThread thread1 = new MyThread();
        thread1.name = "First Thread";
        thread1.arr = arr1;
        thread1.start();

        MyThread thread2 = new MyThread();
        thread2.name = "Second Thread";
        thread2.arr = arr2;
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            System.arraycopy(arr1, 0, arr, 0, HALF);
            System.arraycopy(arr2, 0, arr, HALF, HALF);

            System.out.println("Second method = " + (System.currentTimeMillis() - a));
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
    }
}

class MyThread extends Thread {
    public float[] arr;
    public String name;

    @Override
    public void run() {
        System.out.printf("%s started... \n", name);
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.printf("%s finished. \n", name);
    }
}



