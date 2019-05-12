package lesson2;

import java.util.Arrays;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        System.out.println("Задание №1 Поменять 0 с 1");
        System.out.println(Arrays.toString(changeOneAndZero(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));

        System.out.println("Задание №2 массив с числами кратные трем");
        arrayFor3();
        System.out.println("Задание №3 умножение на 2 всё что меньше 6");
        System.out.println(Arrays.toString(subSix(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1})));

        System.out.println("Задание №4 крест из 1");
        crossOne(5);

        System.out.println("Задание №5");
        minMaxElement(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});

        System.out.println("Задание №6");
        System.out.println(rightLeftSide(new int[]{1, 1, 1, 2, 1}));

        System.out.println("Задание №7");
        System.out.println(Arrays.toString(pushElement(new int[]{1, 2, 3, 4, 5}, -6)));
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] changeOneAndZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
        return arr;
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void arrayFor3() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static int[] subSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void crossOne(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i == j) || (j == (arr.length - 1 - i))) {
                    arr[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minMaxElement(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("min = " + min + "; max = " + max);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

    public static boolean rightLeftSide(int[] arr) {
        int leftSide = 0;
        int rightSide = 0;
        int i = 0;
        int j = 0;
        while (i + j < arr.length) {
            if (leftSide < rightSide) {
                leftSide += arr[i];
                i++;
            } else {
                rightSide += arr[arr.length - 1 - j];
                j++;
            }
        }
        if (leftSide == rightSide) {
            return true;
        } else return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static int[] pushElement(int[] arr, int n) {
        n %= arr.length;
        if (n < 0) {
            n += arr.length;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
            }
        }
        return arr;
    }

}
