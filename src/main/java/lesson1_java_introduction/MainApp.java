package lesson1_java_introduction;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class MainApp {

    //Task1
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Task 2
        int a = 0;
        float b = 0.1F;
        double c = 0.2;
        String d = "строка";
        boolean e = true;
        byte f = 1;
        short g = 2;
        long h = 300000L;
        char i = 'q';


        // Task 3
        float a1 = 1.3F;
        float b1 = 2.6F;
        float c1 = 7.1F;
        float d1 = 9;

        float res1 = formula(a1,b1,c1,d1);
        System.out.println(res1);

        //Task 4
        int a2 = 10;
        int b2 = 20;
        Boolean res2 = sum(a2,b2);
        System.out.println(res2);

        //Task5
        textPositive(50);

        //Task 6
        Boolean res3 = isNegativeNumber(-100);

        //Task 7
        sendHello("GeekBrains");

        //Task 8
        leapYear(1700);
    }

    //Task 3
    public static Float formula(float a, float b, float c, float d){
        return a*(b+(c/d));
    }

    //Task 4
    public static Boolean sum(int a, int b){
        return a + b >= 10 || a + b <= 20;
    }

    //Task 5
    public static void textPositive(int number){
        if (number >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    //Task 6
    public static Boolean isNegativeNumber(int number){
        return number < 0;
    }

    //Task 7
    public static void sendHello(String str){
        System.out.println("Привет " + str + "!");
    }

    //Task 8
    public static void leapYear(int year){
        if (year%4 == 0){
            if (year%100 == 0){
                if (year%400 == 0){
                    System.out.println("Год " + year + " високосный!");
                }
                else System.out.println("Год " + year + " невисокосный!");
            }
            else System.out.println("Год " + year + " високосный!");
        }
        else System.out.println("Год " + year + " невисокосный!");
    }
}
