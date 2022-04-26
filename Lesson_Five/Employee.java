package Lesson_Five;

public class Employee {

     private String fio;
     private String post;
     private String email;
     private long telephone;
     private int salary;
     private int age;

     public Employee(String fio, String post, String email, long telephone, int salary, int age) {
         this.fio = fio;
         this.post = post;
         this.email = email;
         this.telephone = telephone;
         this.salary = salary;
         this.age = age;
     }

     //переделать
     public void outputInformation () {
         System.out.println("ФИО сотрудника: " + this.getFio());
         System.out.println("Должность сотрудника: " + this.getPost());
         System.out.println("Email сотрудника: " + this.getEmail());
         System.out.println("Телефон сотрудника: " + this.getTelephone());
         System.out.println("Зарплата сотрудника: " + this.getSalary());
         System.out.println("Возраст сотрудника: " + this.getAge());
     }

     public int getAge(){
         return age;
     }

    public int getSalary() {
        return salary;
    }

    public long getTelephone() {
        return telephone;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getPost() {
        return post;
    }
}
