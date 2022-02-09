package lesson9_exceptions;

import com.sun.istack.internal.Nullable;

import java.util.Random;

public class MainApp {

    public static void main(String[] args) {

        //for exception change to 5 5
        String[][] array = new String[4][4];

        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = Integer.toString(random.nextInt());
            }
        }

        // for exception
        //array[0][1] = "fdfsdf";

        sumMassive(array);
    }

    public static void sumMassive(String[][] array){
        int sum = 0;

        try{
            if (array.length != 4) throw new MyArraySizeException("Размерность массива должна быть 4х4");

            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array.length; j++){

                    @Nullable
                    Integer number = convertToInt(array[i][j].trim());
                    if (number == null) throw new MyArrayDataException(i, j);
                    else sum += number;
                }
            }

            System.out.println("Сумма элементов массива: " + sum);

        } catch (MyArraySizeException | NumberFormatException e){
            e.printStackTrace();
        }

    }

    public static Integer convertToInt(String s){
        try {
            return Integer.parseInt(s);
        }
        catch(Exception e){
            return null;
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message){
        super(message);
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j){
        System.out.println("В ячейке [" + i + "][" + j + "] лежат неверные данные.");
    }
}
