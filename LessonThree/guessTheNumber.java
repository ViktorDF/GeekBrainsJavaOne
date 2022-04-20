package Lesson_Three;

//Написать программу, которая загадывает случайное число от 0 до 9,
// и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен
// сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос –
// «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean F;
        boolean repeat = true;

        while (repeat) {

            F = true;
            int secretNumber = (int) (Math.random() * 10);
            System.out.println("Я загадал число!\nУгадай!");

            do {
                System.out.print("Введи число: ");
                int numberUser = scanner.nextInt();

                if (numberUser == secretNumber) {
                    System.out.println("Угадал!");
                    F = false;
                    break;
                }
                else if (numberUser > secretNumber) System.out.println("Загаданное число меньше!");
                else System.out.println("Загаданное число больше!");

            } while (F);
            System.out.println("Хочешь сыграть еще разок?\n1 - да, 0 - нет");
            System.out.print("Твой ответ: ");
            int questionRepeat = scanner.nextInt();
            if (questionRepeat == 1) repeat = true;
            else if (questionRepeat == 0) repeat = false;
        }
        System.out.println("Игра закончена!");
    }
}
