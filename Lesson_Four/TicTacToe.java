package Lesson_Four;

import java.util.Random;
import java.util.Scanner;

//1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
//2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
// с использованием циклов.
//3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5.
// Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
//4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

public class TicTacToe {
    public static void main(String[] args) {
        char[][] field = createNewField();

        do {
            doPlayerMove(field);
            drawField(field);
            if (checkWin(field, 'X')) {
                System.out.println("Player won!!!");
                break;
            }
            if (checkDraw(field)) {
                System.out.println("It is draw! Sorry!");
                break;
            }

            System.out.println("===========");
            doPlayerAI(field);
            drawField(field);
            if (checkWin(field, 'O')) {
                System.out.println("AI won!!!");
                break;
            }
            if (checkDraw(field)) {
                System.out.println("It is draw! Sorry!");
                break;
            }
        } while (true);
    }

    static boolean checkDraw(char[][] field) {
        int maxMinus = field.length * field.length;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != '-') {
                    maxMinus--;
                }
            }
        }

        return maxMinus == 0;
    }


    static boolean checkWin(char[][] field, char sign) {
        // Horizontal
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
            }
        }

        // Vertical
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;
            }
        }

        // Main diagonal
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
            return true;
        }

        // Second diagonal
        if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) {
            return true;
        }

        return false;
    }

    static void doPlayerAI(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (field[x][y] != '-');
        field[x][y] = 'O';
    }

    static void doPlayerMove(char[][] field) {
        int x, y;
        do {
            x = getIndexCoordinate('X', field.length);
            y = getIndexCoordinate('Y', field.length);
        } while (field[x][y] != '-');
        field[x][y] = 'X';
    }

    static int getIndexCoordinate(char coordName, int max) {
        return getCoordinate(coordName, max) - 1;
    }

    static int getCoordinate(char coordName, int max) {
        int coord;
        do {
            System.out.println(String.format("Please input %s-coordinate [1-%s]", coordName, max));
            Scanner scanner = new Scanner(System.in);
            coord = scanner.nextInt();
        } while (coord < 1 || coord > max);

        return coord;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    static char[][] createNewField() {
        return new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
    }
}
