package lesson5_oop;

public class Employee {

    private String full_name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    public int age;

    public Employee(String full_name, String position, String email, String phone, int salary, int age){
        this.full_name = full_name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.println(
                "Имя сотрудника: " + full_name + "; Должность: " + position + "; Email: " + email +
                        "; Телефон: " + phone + "; Зарплата: " + salary + "; Возраст: " + age
        );
    }

}