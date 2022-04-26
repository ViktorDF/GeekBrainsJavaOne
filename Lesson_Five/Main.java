package Lesson_Five;

//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//++++++++++++
//Конструктор класса должен заполнять эти поля при создании объекта;
//+++++++++
//Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//+++-----
//Создать массив из 5 сотрудников
//++++++++
//Пример:
//Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
//потом для каждой ячейки массива задаем объект
//persArray[1] = new Person(...);
//...
//persArray[4] = new Person(...);

//С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//+++++++++=

public class Main {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Ivanov Ivan", "Engineer","1@mail.ru",9118,
                1234,31);
        employeesArray[1] = new Employee("Zinchenko Mariya", "Tester", "2@mail.ru",
                897421,1000000,13);
        employeesArray[2] = new Employee("Portr Piter", "Vizer", "3@mail.ru", 74985769,
                645,21);
        employeesArray[3] = new Employee("Yt ytu", "Witcher","4@mail.ru", 67549,
                765,55);
        employeesArray[4] = new Employee("Popka Pop", "Piska", "5@mail.ru",9964578,
                64748,87);

        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40) {
                employeesArray[i].outputInformation();
                System.out.println();
            }

        }
    }
}
