package Lesson_Four;

import java.util.Random;
import java.util.Scanner;

//1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
//2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, 
// с использованием циклов.
//3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5. 
// Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
//4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

public class TicTacToeHome {
    public static void main(String[] args) {
        char[][] field = {
                {'-','-','-'},
                {'-','-','-'},
                {'-','-','-'}
        };

        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        int answer;

        System.out.println("Играем в крестики-нолики");
        do {
            startPlay(field);
            System.out.println("Сыграем еще раз?\n1 - да, 0 - нет");
            answer = scanner.nextInt();
            if (answer == 0) repeat = false;
        } while (repeat);
        System.out.println("Пока!");
    }

    //страт игры
    public static void startPlay(char[][] field){
        drawField(field);
        System.out.println("=====");
        do {
            System.out.println("Ход игрока");
            moveUser(field, 'X');
            drawField(field);
            System.out.println("=====");
            if (checkDraw(field)) {
                System.out.println("Ничья!");
                break;
            }
            if (checkWin(field,'X')) {
                System.out.println("Выиграл Игрок");
                break;
            }
            System.out.println("Ход компьютера");
            moveComputer(field, 'O');
            drawField(field);
            System.out.println("=====");
            if (checkDraw(field)) {
                System.out.println("Ничья!");
                break;
            }
            if (checkWin(field,'O')) {
                System.out.println("Выиграл Компьютер");
                break;
            }
        } while (true);

    }

    //отрисовка поля
    public static void drawField(char[][] playingField) {
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                System.out.print(playingField[i][j] + " ");
            }
            System.out.println();
        }
    }

    //ход игрока
    public static void moveUser(char[][] field, char playerSign) {

        int x = field.length;
        Scanner scanner = new Scanner(System.in);

        int coordinateX;
        int coordinateY;

        do {
            do {
                System.out.printf("Выберите строку (1 - %s): ", x);
                coordinateX = scanner.nextInt();
            } while(coordinateX > field.length || coordinateX < 0);
            do {
                System.out.printf("Выберите столбец (1 - %s): ", x);
                coordinateY = scanner.nextInt();
            } while(coordinateY > field.length || coordinateY < 0) ;
        } while(field[editIndex(coordinateX)][editIndex(coordinateY)] != '-');

        field[editIndex(coordinateX)][editIndex(coordinateY)] = playerSign;
    }
    //правка индексации
    public static int editIndex(int x){
        return x - 1;
    }

    //ход искуственного интелекта
    public static void moveComputer(char[][] field, char playerSign) {

        Random random = new Random();
        int x = field.length;
        int coordinateX;
        int coordinateY;

        do {
                coordinateX = random.nextInt(x);
                coordinateY = random.nextInt(x);
        } while(field[coordinateX][coordinateY] != '-');

        field[coordinateX][coordinateY] = playerSign;

    }

    //проверка на победу
    public static boolean checkWin(char[][] field, char playerSign) {

        //горизонтально
        for (int i = 0; i < field.length; i++) {
            int pointVictory = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == playerSign) pointVictory++;
            }
            if (pointVictory == field.length) return true;
        }

        //вертикально
        for (int i = 0; i < field.length; i++) {
            int pointVictory = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[j][i] == playerSign) pointVictory++;
            }
            if (pointVictory == field.length) return true;
        }

        //горизонталь слева направо
        int pointVictory = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == playerSign) pointVictory++;
        }
        if (pointVictory == field.length) return true;
        else pointVictory = 0;

        //горизонталь справа налево
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i + j == field.length - 1) {
                    if (field[i][j] == playerSign) pointVictory++;
                }
            }
            if (pointVictory == field.length) return true;
            else pointVictory = 0;
        }

        return false;
    }

    //проверка на ничью
    public static boolean checkDraw(char[][] field) {
        int pointDraw = field.length * field.length;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != '-') pointDraw--;
            }
        }
        return pointDraw == 0;
    }


}
