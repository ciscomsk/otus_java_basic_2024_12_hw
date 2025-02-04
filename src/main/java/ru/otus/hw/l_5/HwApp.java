package ru.otus.hw.l_5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HwApp {
    public static void main(String[] args) {
//        printNTimes("AAA", 3);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        sumByConditionAndPrint(arr);

//        fillArray(arr, 5);
//        System.out.println(Arrays.toString(arr));

//        addToArrayElements(arr, 3);
//        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3, 4, 5, 6};
//        compareArrayHalves(arr2);
//        compareArrayHalves(arr3);

//        System.out.println(Arrays.toString(sumArrays(arr, arr2, arr3)));

        int[] arr4 = {1, 1, 1, 1, 1, 5};
        int[] arr5 = {5, 3, 4, -2};
        int[] arr6 = {7, 2, 2, 2};
        int[] arr7 = {9, 4};
        int[] arr8 = {-2, 4, 3, 5};
        System.out.println(getEqualityIndexNaive(arr4));
        System.out.println(getEqualityIndexNaive(arr5));
        System.out.println(getEqualityIndexNaive(arr6));
        System.out.println(getEqualityIndexNaive(arr7));
        System.out.println(getEqualityIndexNaive(arr8));
        System.out.println();
        System.out.println(getEqualityIndex(arr4));
        System.out.println(getEqualityIndex(arr5));
        System.out.println(getEqualityIndex(arr6));
        System.out.println(getEqualityIndex(arr7));
        System.out.println(getEqualityIndex(arr8));

//        System.out.println(checkElementsOrder(arr, SortOrder.ASC));
//        System.out.println(checkElementsOrder(arr2, SortOrder.DESC));

//        revertArray(arr2);
//        System.out.println(Arrays.toString(arr2));
//        revertArray(arr3);
//        System.out.println(Arrays.toString(arr3));
    }

    public static void printNTimes(String str, int num) {
//        for (int i = 0; i < num; i++) {
//            System.out.println(str);
//        }
        // =
        IntStream.range(0, num).forEach(el -> System.out.println(str));
    }

    public static void sumByConditionAndPrint(int[] arr) {
        int sum = 0;

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > 5) {
//                sum += arr[i];
//            }
//        }
        // =
//        for (int num : arr) {
//            if (num > 5) {
//                sum += num;
//            }
//        }
        // =
        sum = Arrays.stream(arr).filter(el -> el > 5).sum();

        System.out.println(sum);
    }

    public static void fillArray(int[] arr, int value) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = value;
//        }
        // =
        Arrays.fill(arr, value);
    }

    public static void addToArrayElements(int[] arr, int value) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] += value;
//        }
        // =
        IntStream.range(0, arr.length).forEach(idx -> arr[idx] += value);
    }

    public static void compareArrayHalves(int[] arr) {
        int leftHalfSum = 0;
        int rightHalfSum = 0;

        // for arrays with an odd number of elements, we assume that the middle element belongs to both halves
        int oddArrModifier = (arr.length % 2 == 0) ? 0 : 1;

        for (int i = 0; i < arr.length / 2 + oddArrModifier; i++) {
            leftHalfSum += arr[i];
        }

        for (int i = arr.length / 2; i < arr.length; i++) {
            rightHalfSum += arr[i];
        }

        if (leftHalfSum >= rightHalfSum) {
            System.out.println("Left half " + leftHalfSum + " >= right half " + rightHalfSum);
        } else {
            System.out.println("Right half " + rightHalfSum + " > light half " + leftHalfSum);
        }
    }

    public static int[] sumArrays(int[]... arrays) {
        int maxArrLength = 0;

//        for (int i = 0; i < arrays.length; i++) {
//            if (arrays[i].length > maxArrLength) {
//                maxArrLength = arrays[i].length;
//            }
//        }
        // =
//        for (int[] array : arrays) {
//            if (array.length > maxArrLength) {
//                maxArrLength = array.length;
//            }
//        }

        maxArrLength = Arrays.stream(arrays).map(arr -> arr.length).max(Integer::compare).orElse(0);

        int[] resultArray = new int[maxArrLength];

//        for (int i = 0; i < arrays.length; i++) {
//            for (int j = 0; j < arrays[i].length; j++) {
//                resultArray[j] += arrays[i][j];
//            }
//        }
        // =
        for (int[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                resultArray[i] += array[i];
            }
        }

        return resultArray;
    }

    public static int getEqualityIndexNaive(int[] arr) {
        int leftHalfSum = 0;
        int rightHalfSum = 0;

        for (int i = 0; i < arr.length; i++) {
            leftHalfSum += arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                rightHalfSum += arr[j];
            }

            if (leftHalfSum == rightHalfSum) {
                return i;
            }

            rightHalfSum = 0;
        }

        return -1;
    }

    public static int getEqualityIndex(int[] arr) {
        int leftHalfSum = 0;
        int arrSum = Arrays.stream(arr).sum();

        if (arrSum % 2 != 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) { // ? оптимизация: arr.length - 1
            leftHalfSum += arr[i];
            if (leftHalfSum * 2 == arrSum) {
                return i;
            }
        }

        return -1;
    }

    public static boolean checkElementsOrder(int[] arr, SortOrder order) {
        // можно заменить if на switch
        if (order == SortOrder.ASC) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] >= arr[i + 1]) {
                    return false;
                }
            }
        }

        if (order == SortOrder.DESC) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void revertArray(int[] arr) {
        int temp;
        int mirrorIndex;

        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            mirrorIndex = arr.length - 1 - i;

            arr[i] = arr[mirrorIndex];
            arr[mirrorIndex] = temp;
        }
    }
}
