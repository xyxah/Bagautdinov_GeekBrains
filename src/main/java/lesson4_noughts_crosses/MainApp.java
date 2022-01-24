package lesson4_noughts_crosses;

import java.util.Random;
import java.util.Scanner;

public class MainApp {

    public static char[][] MAP;
    public static final int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static int DOTS_BEFORE_WIN = 2;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        drawTable(MAP);
        while (true) {
            humanStep();
            drawTable(MAP);
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            compStep();
            drawTable(MAP);
            if (checkWin(DOT_O)) {
                System.out.println("Победил Компьютер.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена.");
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void drawTable(char[][] map) {
        System.out.println(" -------------");
        for(int i = 0; i < SIZE;i++){
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" | ");
                System.out.print(map[i][j]);
            }
            System.out.println(" |");
            System.out.println(" -------------");
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return MAP[y][x] == DOT_EMPTY;
    }

    public static void humanStep() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[y][x] = DOT_X;
    }

    public static void compStep() {
        int x, y;
        if (!blockPlayer()) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));

            System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
            MAP[y][x] = DOT_O;
        }
    }

    public static boolean blockPlayer() {
        int dots = 0;
        int x;
        int y;

        // Ось X
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (MAP[i][j] == DOT_X)
                    dots++;
                if (dots == DOTS_BEFORE_WIN){
                    y = checkClearY(i);
                    if (y != -1 && isCellValid(i,y)) {
                        MAP[y][i] = DOT_O;
                        return true;
                    }
                }
            }
            dots = 0;
        }

        // Ось Y
        for(int j = 0; j < SIZE; j++){
            for (int i = 0; i < SIZE; i++){
                if (MAP[i][j] == DOT_X) dots++;
                if (dots == DOTS_BEFORE_WIN){
                    x = checkClearX(i);
                    if (x != -1 && isCellValid(x,j)) {
                        MAP[j][x] = DOT_O;
                        return true;
                    }
                }
            }
            dots = 0;
        }

        // Диагональ
        for (int i = 0; i < SIZE; i++){
            if (MAP[i][i] == DOT_X) dots++;
            if (dots == DOTS_BEFORE_WIN){
                int k = checkClearDiag();
                if (k != -1 && isCellValid(k,k)) {
                    MAP[k][k] = DOT_O;
                    return true;
                }
            }
        }


        // Обратная Диагональ
        dots = 0;
        for (int i = SIZE - 1; i >= 0; i--){
            if (MAP[i][SIZE - 1 - i] == DOT_X) dots++;
            if (dots == DOTS_BEFORE_WIN){
                String k = checkClearBackDiag();
                if (k != null) {
                    int x1 = Integer.parseInt(String.valueOf(k.charAt(0)));
                    int y1 = Integer.parseInt(String.valueOf(k.charAt(1)));
                    if (isCellValid(x1,y1)) {
                        MAP[y1][x1] = DOT_O;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int checkClearY(int X) {
        for (int y = 0; y < SIZE; y++){
            if (MAP[X][y] == DOT_EMPTY) return y;
        }
        return -1;
    }

    public static int checkClearX(int Y) {
        for (int x = 0; x < SIZE; x++){
            if (MAP[x][Y] == DOT_EMPTY) return x;
        }
        return -1;
    }

    public static int checkClearDiag() {
        for (int i = 0; i < SIZE; i++){
            if (MAP[i][i] == DOT_EMPTY) return i;
        }
        return -1;
    }

    public static String checkClearBackDiag() {
        for (int i = SIZE - 1; i >= 0; i--) {
            if (MAP[i][SIZE - 1 - i] == DOT_EMPTY){
                int y = SIZE - 1 - i;
                return Integer.toString(i) + y;
            }
        }
        return null;
    }

    public static boolean checkWin(char symb) {
        int dots = 1;

        // Ось X
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (MAP[i][j] != DOT_EMPTY && j > 0) {
                    if (MAP[i][j] == MAP[i][j - 1])
                        dots++;
                    if (dots == DOTS_TO_WIN) return true;
                }
            }
            dots = 1;
        }

        // Ось Y
        for (int j = 0; j < SIZE; j++){
            for (int i = 0; i < SIZE; i++){
                if (MAP[i][j] != DOT_EMPTY && i > 0) {
                    if (MAP[i][j] == MAP[i - 1][j]) dots++;
                    if (dots == DOTS_TO_WIN) return true;
                }
            }
            dots = 1;
        }

        // Диагональ
        for (int i = 0; i < SIZE; i++){
            if (MAP[i][i] != DOT_EMPTY && i > 0) {
                if (MAP[i][i] == MAP[i - 1][i - 1]) dots++;
                if (dots == DOTS_TO_WIN) return true;
            }
        }

        // Обратная Диагональ
        dots = 0;
        for (int i = SIZE - 1; i >= 0; i--){
            if (MAP[i][SIZE - 1 - i] == symb) dots++;
            if (dots == DOTS_TO_WIN) return true;
        }

        return false;
    }
}
