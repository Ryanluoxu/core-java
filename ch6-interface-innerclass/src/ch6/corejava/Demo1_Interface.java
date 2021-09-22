package ch6.corejava;

import java.util.Arrays;

public class Demo1_Interface {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new Employee("John", 5000.0);
        employees[1] = new Employee("Sam", 3000.0);
        employees[2] = new Employee("Ryan", 8000.0);

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

/**
 * 需要实现 Comparable 接口，才能被 sort
 */
class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;

    @Override
    public int compareTo(Employee otherEmployee) {
        if (this.salary == otherEmployee.salary) {
            return 0;
        } else if (this.salary > otherEmployee.salary) {
            return 1;
        }
        return -1;
    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


}


