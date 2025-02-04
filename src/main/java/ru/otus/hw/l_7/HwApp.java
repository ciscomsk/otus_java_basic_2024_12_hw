package ru.otus.hw.l_7;

public class HwApp {
    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {0, -5, 5}};
//        System.out.println(sumOfPositiveElements(arr));
//        System.out.println();

//        printSquare(4);
//        System.out.println();

//        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        print2DArray(arr2);
//        System.out.println();
//        nullifyDiagonals(arr2, MatrixDiagonals.MAIN);
//        nullifyDiagonals(arr2, MatrixDiagonals.SECONDARY);
//        nullifyDiagonals(arr2, MatrixDiagonals.BOTH);
//        print2DArray(arr2);

//        System.out.println(findMax(arr));
//        System.out.println();

//        System.out.println(secondElementSum(arr2, MatrixElements.ROW));
//        System.out.println(secondElementSum(arr2, MatrixElements.COLUMN));
        int[][] arr3 = {{1, 2, 3}};
        print2DArray(arr3);
        System.out.println(secondElementSum(arr3, MatrixElements.ROW));
        System.out.println(secondElementSum(arr3, MatrixElements.COLUMN));
    }

    public static void print2DArray(int[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        // =
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] > 0) {
//                    sum += arr[i][j];
//                }
//            }
//        }
        // =
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    sum += anInt;
                }
            }
        }

        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void nullifyDiagonals(int[][] arr, MatrixDiagonals diagonalToNullify) {
//        if (diagonalToNullify == MatrixDiagonals.MAIN) {
//            int j = 0;
//
//            for (int i = 0; i < arr.length; i++) {
//                arr[i][j] = 0;
//                j += 1;
//            }
//        }
        // ->
        // можно заменить if на switch
        if (diagonalToNullify == MatrixDiagonals.MAIN) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][i] = 0;
            }
        }

        if (diagonalToNullify == MatrixDiagonals.SECONDARY) {
            int j = arr[0].length - 1;

            for (int i = 0; i < arr.length; i++) {
                // v1
//                arr[i][j] = 0;
//                j -= 1;

                // v2
                arr[i][arr[0].length - 1 - i] = 0;

            }
        }
        // 0 2
        // 1 1
        // 2 0

//        if (diagonalToNullify == MatrixDiagonals.BOTH) {
//            int jMain = 0;
//            int jSec = arr[0].length - 1;
//
//            for (int i = 0; i < arr.length; i++) {
//                arr[i][jMain] = 0;
//                arr[i][jSec] = 0;
//
//                jMain += 1;
//                jSec -= 1;
//            }
//        }
        // ->
        if (diagonalToNullify == MatrixDiagonals.BOTH) {
            int jSec = arr[0].length - 1;

            for (int i = 0; i < arr.length; i++) {
                arr[i][i] = 0;
                arr[i][jSec] = 0; // можно и без доп переменной - v2 в MatrixDiagonals.SECONDARY

                jSec -= 1;
            }
        }
    }

    public static int findMax(int[][] arr) {
//        int max = Integer.MIN_VALUE; // v1 - ограничены int
        int max = arr[0][0];

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] > max) {
//                    max = arr[i][j];
//                }
//            }
//        }
        // =
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }

        return max;
    }

    public static int secondElementSum(int[][] arr, MatrixElements element) {
        int sum = 0;

        // можно заменить if на switch
        if (element == MatrixElements.ROW) {
            if (arr.length < 2) {
                return -1;
            }

            int yCoord = 1;
            for (int x = 0; x < arr[yCoord].length; x++) {
                sum += arr[yCoord][x];
            }
        }

        if (element == MatrixElements.COLUMN) {
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i].length < 2) {
//                    return -1;
//                }
//            }
            // =
            for (int[] ints : arr) {
                if (ints.length < 2) {
                    return -1;
                }
            }

            int xCoord = 1;
//            for (int y = 0; y < arr.length; y++) {
//                sum += arr[y][xCoord];
//            }
            // =
            for (int[] ints : arr) {
                sum += ints[xCoord];
            }
        }

        return sum;
    }
}
