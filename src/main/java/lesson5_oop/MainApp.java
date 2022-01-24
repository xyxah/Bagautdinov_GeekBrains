package lesson5_oop;

public class MainApp {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван", "Водитель", "ivanovivan@mailbox.com","89455093401", 25000, 42);
        employees[1] = new Employee("Курочкин Матвей", "Инженер", "koko@mailbox.com","89123972356", 40000, 36);
        employees[2] = new Employee("Корешков Петр", "Механик", "korpet@mailbox.com","89174018583", 37000, 47);
        employees[3] = new Employee("Волков Андрей", "Медик", "volkan@mailbox.com","89874509213", 62000, 23);
        employees[4] = new Employee("Терешкова Ирина", "Кассир", "tereshkovir@mailbox.com","89455093401", 19000, 50);

        for (Employee employee : employees) if (employee.age > 40) employee.info();
    }
}
