package Lesson_Eight.GUI.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //задаем переменные для подсчетов
    private String operation;
    private double firstValue;
    private double secondValue;
    private double result;


    public MainFrame() {
        //задаем название окна
        setTitle("Calculator");
        //задаем размеры окна и где он появится
        setBounds(100, 100, 300, 500);
        //Делаем так, чтобы при закрытие окна завершается программа
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //указываем расположение элементов, указывая внутри
        // как именно будут располагаться элементы
        setLayout(new BorderLayout());

        //пробы пера как говорится
        //пробуем содать надпись сверху

        JPanel name = new JPanel();
        add(name, BorderLayout.NORTH);

        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel calculator = new JLabel("калькулятор");
        calculator.setFont(font);
        calculator.setHorizontalAlignment(SwingConstants.CENTER);
        name.add(calculator, BorderLayout.CENTER);


        //Создаем внутренние "окна" для управления распоожения элементами,
        // то есть делим внутренние окно на части
        JPanel top = new JPanel();
        //добавляем нашу панель в центр окна
        add(top, BorderLayout.CENTER);
        //задаем ожидаемое расположение элементов внутри
        top.setLayout(new GridLayout(4, 3));
        //сздаем еще одно внутренне окно
        JPanel bottom = new JPanel();
        //добавляем наше окно
        add(bottom, BorderLayout.SOUTH);
        //указываем как должны раполагаться элементы внутри
        bottom.setLayout(new BorderLayout());

        //создаем поле ввода
        JTextField inputField = new JTextField();
        //созданный нами класс для реализации интерфейса,
        // который "слушает" нажатия кнопок. Создаем его объект
        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);
        //с помощью цикла создаем наши кнопки,
        //также сразу подключаем к ним прослушивание и добавляем на экран
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonListener);
            top.add(btn);
        }

        //Здесь создаем и добавляем наши кнопки операций
        JButton add = new JButton("+");
        top.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstValue = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operation = "+";
            }
        });
        JButton minus = new JButton("-");
        top.add(minus);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstValue = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operation = "-";
            }
        });
        JButton multiple = new JButton("*");
        top.add(multiple);
        multiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstValue = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operation = "*";
            }
        });
        JButton divide = new JButton("/");
        top.add(divide);
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstValue = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operation = "/";
            }
        });
        JButton pow = new JButton("^");
        top.add(pow);
        pow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstValue = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operation = "^";
            }
        });
        JButton submit = new JButton("=");
        top.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                secondValue = Double.parseDouble(inputField.getText());

                if ("+".equals(operation)) result = firstValue + secondValue;
                if ("-".equals(operation)) result = firstValue - secondValue;
                if ("/".equals(operation)) result = firstValue / secondValue;
                if ("*".equals(operation)) result = firstValue * secondValue;
                if ("^".equals(operation)) result = Math.pow(firstValue, secondValue);

                inputField.setText(String.format("Результат: %s", result));
            }
        });


        //добавляем окно ввода внизу и распологаем его по центру
        bottom.add(inputField, BorderLayout.CENTER);
        //добавляем кнопку для отчистки
        JButton clear = new JButton("C");
        clear.addActionListener(new ClearButtonListener(inputField));
        bottom.add(clear, BorderLayout.EAST);

        //для видимости
        setVisible(true);

    }


    public static class ClearButtonListener implements ActionListener {
        private JTextField inputField;

        public ClearButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
        }
    }
}