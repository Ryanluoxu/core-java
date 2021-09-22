package ch5.corejava;

import java.util.ArrayList;
import java.util.List;

public class Demo1_Inheritance {
    public static void main(String[] args) {
        /**
         * 一个对象变量，可以引用多种实际类型。称为多态。
         * 运行时，能够自动选择调用的方法。称为动态绑定。
         */
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(5000, "James"));
        list.add(new Employee(5500, "Mike"));
        list.add(new Manager(8000, "Tim", 1000));
        for (Employee employee : list) {
            System.out.println(employee.getSalary());
        }

        /**
         * 在进行类型转换（从上向下）之前，使用 instanceof 检查
         */
        Employee jason = new Employee(5000, "Jason");
        if (jason instanceof Manager) {
            Manager manager = (Manager) jason;
        }
    }
}

class Employee {
    private int salary;
    private String name;

    public Employee getBuddy() {
        return null;
    }

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        try {
            return ObjectAnalyzer.toString(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Manager extends Employee {
    private int bonus;

    public Manager() {
        super(0, "");
    }

    public Manager(int salary, String name, int bonus) {
        super(salary, name);
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + this.bonus;
    }

    /**
     * 子类覆盖的方法，返回类型可以是父类返回类型的子类。
     */
    @Override
    public Manager getBuddy() {
        return null;
    }
}