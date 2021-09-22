package ch5.corejava;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Demo8_Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        /**
         * 通过对象，获取类对象
         */
        Employee employee = new Employee(5000, "John");
        Class cls = employee.getClass();
        System.out.println("cls.getName(): " + cls.getName());  // ch5.corejava.Employee

        /**
         * 通过完整名字，获取类对象
         */
        String className = "ch5.corejava.Manager";
        Class cls2 = Class.forName(className);
        System.out.println("cls2.getName(): " + cls2.getName());

        /**
         * 通过类，获得类对象
         */
        Class cls3 = Employee.class;
        System.out.println("cls3.getName(): " + cls3.getName());

        /**
         * JVM 为每个类型管理一个 class 对象，所以可以直接用 == 来比较
         */
        if (employee.getClass() == Employee.class) {
            System.out.println("employee.getClass() == Employee.class");
        }

        /**
         * 通过 class 对象创建对象
         */
        if (cls2 == Manager.class) {
            Manager manager = (Manager) cls2.newInstance();
            System.out.println("manager.getClass(): " + manager.getClass());
        }

        test2();
        test3();

    }

    /**
     * 利用反射来分析类：
     */
    private static void test2() throws ClassNotFoundException {
        System.out.println("\ntest2: ");
        String className = "java.util.Date";
        Class cls = Class.forName(className);
        System.out.println("cls: " + cls);
        Class superCls = cls.getSuperclass();
        System.out.println("superCls: " + superCls);
        String modifiers = Modifier.toString(cls.getModifiers());
        System.out.println("modifiers: " + modifiers);

        printConstructors(cls);
        printMethods(cls);
        printFields(cls);
    }

    private static void printConstructors(Class cls) {
        Constructor[] constructors = cls.getDeclaredConstructors();
        System.out.println("constructors:");
        for (Constructor constructor : constructors) {
//            System.out.println(constructor.toString());
            StringBuilder sb = new StringBuilder();
            String modifiers = Modifier.toString(cls.getModifiers());
            String className = cls.getName();
            sb.append(modifiers).append(" ").append(className).append("(");
            Class[] paramClasses = constructor.getParameterTypes();
            for (Class paramClass : paramClasses) {
                sb.append(paramClass.getName()).append(",");
            }
            int index = sb.lastIndexOf(",");
            if (index > 0) {
                sb.deleteCharAt(index);
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
    }

    private static void printMethods(Class cls) {
//        cls.getMethods()    // only public methods
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("methods:");
        for (Method method : methods) {
//            System.out.println(method);
            StringBuilder sb = new StringBuilder();
            sb.append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType().getName()).append(" ");
            sb.append(method.getName()).append("(");
            Class[] paramClasses = method.getParameterTypes();
            for (Class paramClass : paramClasses) {
                sb.append(paramClass.getName()).append(",");
            }
            int index = sb.lastIndexOf(",");
            if (index > 0) {
                sb.deleteCharAt(index);
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
    }

    private static void printFields(Class cls) {
        Field[] fields = cls.getDeclaredFields();
        System.out.println("fields:");
        for (Field field : fields) {
            System.out.println(field.toString());
        }
    }

    /**
     * 利用反射分析对象：
     */
    private static void test3() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("\ntest3:");
        Employee harry = new Employee(5000, "Harry");
        Class cls = harry.getClass();
        Field nameField = cls.getDeclaredField("name");
        System.out.println("nameField: " + nameField);
        /**
         * get value of object's field
         *
         * 由于 name 是一个私有域，只要有 get 方法才能获取它的值，这里会报 IllegalAccessException。
         * 但是可以通过 setAccessible 克服。
         */
        nameField.setAccessible(true);      // 克服 private
        Object harryName = nameField.get(harry);
        System.out.println("harryName: " + harryName);

        harry.setName("Hanna");
        harryName = nameField.get(harry);
        System.out.println("harryName: " + harryName);

        System.out.println("\ntest ObjectAnalyzer:");
        System.out.println(ObjectAnalyzer.toString(harry));

        Employee jason = new Employee(5200, "Jason");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(jason);
        employeeList.add(harry);
        System.out.println(ObjectAnalyzer.toString(employeeList));
    }
}

class ObjectAnalyzer {
    public static String toString(Object obj) throws IllegalAccessException {
        Class cls = obj.getClass();
        StringBuilder sb = new StringBuilder(cls.getName());
        sb.append(" [");
        do {
            Field[] fields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                sb.append(field.getName())
                        .append("=")
                        .append(field.get(obj))
                        .append(";");
            }
            cls = cls.getSuperclass();

        } while (cls != null);
        sb.append(" ]");
        return sb.toString();
    }
}

