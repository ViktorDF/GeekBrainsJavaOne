package Lesson_One;

public class LessonOne {
    public static void main(String[] args) {
        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 10;
        short s = 123;
        int i = 1234;
        long l = 1000000l;
        float f = 123.4545f;
        double d = 1215326.8724572865;
        char c = 'F';
        boolean bb = true;

        //3
        System.out.println(count(10,11,12,13));

        //4
        System.out.println(check(1.1, 2));

        //5
        checkPositive(-1);
        checkPositive(1);

        //6
        System.out.println(checkNegative(1));

        //7
        greet("Витя");

        //8
        checkLeapYear(2100);

    }

    //3. Написать метод вычисляющий выражение
    // a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    static double count(int a, int b, int c, int d) {
        return a * ( b + ( c / d ) );
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
    // в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    static boolean check(double a, double b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        }
        return false;
    }

    //5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    // Замечание: ноль считаем положительным числом.
    static void checkPositive(int a){
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    //6. Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;
    static boolean checkNegative(int a) {
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    static void greet(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static void checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            System.out.println("Год високосный");
        } else System.out.println("Год не високосный");
    }
}
