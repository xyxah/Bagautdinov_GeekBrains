package lesson11_generalizations;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        //Task 1
        String[] array = {"first", "second", "third","fourth"};
        switchArrayElements(array, 0,3);
        System.out.println(Arrays.toString(array));
        System.out.println();

        //Task 2
        convertToArrayList(array);

        //Task 3
        Box<Apple> boxApple = new Box();
        for (int i = 0; i < 2; i++){
            boxApple.add(new Apple());
        }

        Box<Orange> boxOrange = new Box();
        for (int i = 0; i < 3; i++){
            boxOrange.add(new Orange());
        }

        System.out.println("apples weight = " + boxApple.getWeight());
        System.out.println("oranges weight = " + boxOrange.getWeight());


        Box<Apple> boxApple1 = new Box();
        boxApple.moveAt(boxApple1);

        System.out.println("apples weight = " + boxApple.getWeight());
        System.out.println("apples 1 weight = " + boxApple1.getWeight());
        System.out.println(boxApple.compare(boxApple1));
    }

    public static <T> void switchArrayElements(T[] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T> List<T> convertToArrayList(T[] array){
        return Arrays.asList(array);
    }

}
