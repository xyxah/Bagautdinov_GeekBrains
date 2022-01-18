package lesson3_practic;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        // Task 1
        guessNumber();

        // Task 2
        guessWord();
    }

    public static void guessNumber(){
        int max = 9;
        int randomNumber = (int) (Math.random() * ++max);

        System.out.println("Загадано число от 0 до 9.");
        System.out.println("У вас имеется 3 попытки, чтобы отгадать число.");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++){

            int number = scanner.nextInt();
            boolean res = diff(randomNumber, number);
            if (res) break;

            if (i == 2) System.out.println("Загаднное число = " + randomNumber);
        }

        System.out.println("\nХотите продолжить?");
        System.out.println("1 - да, 0 - нет.");
        int next = scanner.nextInt();
        if (next == 1) guessNumber();
        System.out.println();
    }

    public static boolean diff(int random, int number) {

        int diff = random - number;

        if (diff > 0) {
            System.out.println("Загаданное число больше набранного.");
            return false;
        }
        if (diff < 0) {
            System.out.println("Загаданное число меньше набранного.");
            return false;
        }

        System.out.println("Вы отгадали число.");
        return true;
    }

    public static void guessWord(){
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"
        };

        Random random = new Random();
        int randomNumber = random.nextInt(words.length);
        String hiddenWord = words[randomNumber];

        System.out.println("Загадано слово");
        Scanner scanner = new Scanner(System.in);
        String word;
        boolean win;

        do{
            word = scanner.nextLine();
            win = stringEquals(word.toLowerCase(Locale.ROOT),hiddenWord);
        }
        while (!win);
    }

    public static boolean stringEquals(String word, String hiddenWord) {
        word = addHiddenChars(word);
        hiddenWord = addHiddenChars(hiddenWord);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 15; i++){

            if (word.equals(hiddenWord)){
                System.out.println("Вы отгадали слово.");
                return true;
            }

            char symbol = word.charAt(i);
            char trueSymbol = hiddenWord.charAt(i);

            if (symbol == trueSymbol) res.append(trueSymbol);
            else res.append("#");
        }
        System.out.println(res);
        System.out.println("\nПопробуйте еще раз.");
        return false;
    }

    public static String addHiddenChars(String word) {
        int maxLength = 15;
        int currentLength = word.length();
        int diff = maxLength - currentLength;

        StringBuilder hiddenChars = new StringBuilder();

        for (int i = 0; i < diff; i ++)
            hiddenChars.append("#");

        return word + hiddenChars;
    }
}
