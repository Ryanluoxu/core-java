package ch5.corejava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo10_Reflect_MethodPointer {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 方法指针
         */
        Method square = Demo10_Reflect_MethodPointer.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
        /*
        printTable - method:public static double ch5.corejava.Demo10_Reflect_MethodPointer.square(double)
            1.0000 |     1.0000
            2.0000 |     4.0000
            3.0000 |     9.0000
            4.0000 |    16.0000
            5.0000 |    25.0000
            6.0000 |    36.0000
            7.0000 |    49.0000
            8.0000 |    64.0000
            9.0000 |    81.0000
           10.0000 |   100.0000
        printTable - method:public static double java.lang.Math.sqrt(double)
            1.0000 |     1.0000
            2.0000 |     1.4142
            3.0000 |     1.7321
            4.0000 |     2.0000
            5.0000 |     2.2361
            6.0000 |     2.4495
            7.0000 |     2.6458
            8.0000 |     2.8284
            9.0000 |     3.0000
           10.0000 |     3.1623
         */
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method method) throws InvocationTargetException, IllegalAccessException {
        System.out.println("printTable - method:" + method);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            /**
             * 这里的方法是 static 方法，所以不需要指定 object，只要提供入参即可。
             * 如果是非 static 方法，那就与特定 object 的状态有关。
             */
            double y = (double) method.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }

}
