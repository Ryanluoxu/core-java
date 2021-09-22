package ch5.corejava;

public class Demo2_Abstract {
    /**
     * 上层的父类包含的都是通用的方法，当不确定如何实现方法时，可以先抽象，之后在子类中具体实现。
     */
    public static void main(String[] args) {

        /**
         * 抽象类不能被实例化: x new Person();
         *
         * 抽象类的变量 p，可以引用非抽象子类的实例.
         * 动态绑定。
         */
        Person p = new Student();
        p.getDescription();
    }
}

class Student extends Person {

    @Override
    public String getDescription() {
        return "student: " + this.getName();
    }
}

abstract class Person {
    public abstract String getDescription();

    /**
     * 仍然保留通用的属性
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
