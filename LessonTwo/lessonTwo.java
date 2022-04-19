//правка
package Lesson_Two;

import org.w3c.dom.ls.LSOutput;

public class lessonTwo {
    public static void main(String[] args) {

        //1
        System.out.println("Задание один");
        int[] oneZero = {0,1,1,0,1,0};

        replacingOneWithZero(oneZero);

        for (int i = 0; i < oneZero.length; i++) {
            System.out.print(oneZero[i] + " ");
        }
        System.out.println();

        //2
        System.out.println("Задание два");
        int[] eightNull = new int[8];
        fillingTheArray(eightNull);
        for (int i = 0; i < eightNull.length; i++) {
            System.out.print(eightNull[i] + " ");
        }
        System.out.println();

        //3
        System.out.println("Задание три");
        int[] sixPower = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplicationByTwo(sixPower);
        for (int i = 0; i < sixPower.length; i++) {
            System.out.print(sixPower[i] + " ");
        }
        System.out.println();

        //4
        System.out.println("Задание четыре");
        int[][] diagonals = fillingInDiagonals();
        for (int i = 0; i < diagonals.length; i++) {
            for (int j = 0; j < diagonals[i].length; j++) {
                System.out.print(diagonals[i][j] + " " + "\t");
            }
            System.out.println();
        }
        System.out.println();

        //5
        System.out.println("Задание пять");
        int[] minMax = {1, 5, 3, 2, 11, 4, 12, 2, 4, 8, 9, 0};
        searchForMinimumAndMaximum(minMax);
        System.out.println();

        //6
        System.out.println("Задание шесть");
        int[] check = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(check));
        System.out.println();

        //7
        System.out.println("Задание семь");
        offset(minMax,-2);
        for (int i = 0; i < minMax.length; i++) {
            System.out.print(minMax[i] + " ");
        }
        System.out.println();
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void replacingOneWithZero(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else if (arr[i] == 1) arr[i] = 0;
        }
    }
    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void fillingTheArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }
    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void multiplicationByTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static int[][] fillingInDiagonals() {

        int size = 5;
        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i + j == arr.length - 1)arr[i][j] = 1;
            }
        }
        return arr;
    }
    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void searchForMinimumAndMaximum(int[] arr) {

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        System.out.println("Минимальное значение массива: " + min);
        System.out.println("Максимальное значение массива: " + max);
    }
    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    static boolean checkBalance(int[] arr) {

        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft = sumLeft + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sumRight = sumRight + arr[j];
            }
            if (sumLeft == sumRight) return true;
            else sumRight = 0;
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить
    // все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    static void offset(int[] arr, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int buf = arr[0];
                arr[0] = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[1] = buf;
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                int buf = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];
                for (int j = 0; j < arr.length - 2; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 2] = buf;
            }
        }
    }
}