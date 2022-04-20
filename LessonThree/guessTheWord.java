package Lesson_Three;

//Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
// "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
// "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
// "pineapple", "pumpkin", "potato"};
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
// Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.

import java.util.Scanner;

public class guessTheWord {
    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);

        boolean F;
        boolean repeat;
        int numberOfAttempts;

        do {

            numberOfAttempts = 1;
            F = true;
            String smokeWord = "###############";
            char[] smokeWordChar = smokeWord.toCharArray();
            int numberSecretWord = (int) (Math.random() * 24);
            String secretWord = words[numberSecretWord];
            System.out.println("Я загадал слово!\nУгадай!");
            char[] secretWordChar = secretWord.toCharArray();

            do {

                System.out.print("Введи слово: ");
                String answer = scanner.nextLine();
                char[] answerChar = answer.toCharArray();

                if (answer.equals(secretWord)) {
                    System.out.println("Угадал!");
                    System.out.println("Количетсво попыток: " + numberOfAttempts);
                    System.out.println("Загаданное слово: " + secretWord);
                    F = false;
                    break;
                } else {
                    System.out.println("Не угадал!");
                    numberOfAttempts++;
                }

                for (int i = 0; i < answerChar.length; i++) {
                    if (i >= secretWordChar.length - 1) break;
                    if (answerChar[i] == secretWordChar[i])
                        smokeWordChar[i] = answerChar[i];
                }

                for (int i = 0; i < smokeWordChar.length; i++) {
                    System.out.print(smokeWordChar[i]);
                }
                System.out.println();

            } while (F);
            System.out.println("Хочешь сыграть еще разок?\n1 - да, любой другой символ - нет");
            System.out.print("Твой ответ: ");
            int questionRepeat = scanner.nextInt();
            if (questionRepeat == 1) repeat = true;
            else repeat = false;
        } while (repeat);
        System.out.println("Игра закончена!");
    }
}
