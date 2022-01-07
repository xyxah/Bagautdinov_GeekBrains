package lesson2_basic_constructions;

public class MainApp {

    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1");
        int[] arr1 = {0,1,1,0,1,1,0,0,0,1};

        for (int i = 0; i < arr1.length; i++){
            System.out.print("arr1 [" + i + "] = " + arr1[i] + "  ->  ");

            if (arr1[i] == 1) arr1[i] = 0;
            else if (arr1[i] == 0) arr1[i] = 1;

            System.out.println("arr1 [" + i + "] = " + arr1[i]);
        }
        System.out.println();



        // Task 2
        System.out.println("Task 2");
        int[] arr2 = new int[8];

        for (int i = 0; i < arr2.length; i++){
            arr2[i] = i * 3;
            System.out.println("arr2 [" + i + "] = " + arr2[i]);
        }
        System.out.println();



        // Task 3
        System.out.println("Task 3");
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arr3.length; i++){
            System.out.print("arr3 [" + i + "] = " + arr3[i]);

            if (arr3[i] < 6) {
                arr3[i] *= 2;
                System.out.print("  ->  arr3 [" + i + "] = " + arr3[i]);
            }

            System.out.println();
        }
        System.out.println();



        // Task 4
        System.out.println("Task 4");
        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++){
            for (int j = 0; j < arr4[i].length; j++){
                if (i == j) arr4[i][j] = 1;
                else arr4[i][j] = 0;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();



        // Task 5
        System.out.println("Task 5");
        int max = 0;
        int[] arr5 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arr5.length; i++){
            System.out.println("arr5 [" + i + "] = " + arr5[i]);
            if (arr5[i] > max) max = arr5[i];
        }
        System.out.println("\nmax = " + max + "\n");



        // Task 6
        System.out.println("Task 6");
        int[] arr6 = {1,2,3};
        System.out.println(task6(arr6));
    }

    public static boolean task6 (int[] arr) {

        for (int i = 0; i < arr.length; i++){

            int left_sum = 0;
            int right_sum = 0;

            for (int j = 0; j <= i; j++){
                left_sum += arr[j];
            }
            System.out.print("left = " + left_sum);

            for (int k = i + 1; k < arr.length; k ++){
                right_sum += arr[k];
            }
            System.out.println(" right = " + right_sum);

            if (left_sum == right_sum) return true;
        }
        return false;
    }

}


