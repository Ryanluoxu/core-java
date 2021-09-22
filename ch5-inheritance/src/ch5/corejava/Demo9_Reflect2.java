package ch5.corejava;

import java.lang.reflect.Array;

public class Demo9_Reflect2 {
    public static void main(String[] args) {
        /**
         * 使用反射，编写泛型数组
         */
        Employee[] employees = new Employee[100];
        // ... employees is full.
        employees = (Employee[]) arrayGrow(employees);

    }

    /**
     * 用于扩展数组的通用方法:
     * 可以将一个 Employee[] 临时转换成 Object[], 再转回去。
     * 但是，一开始就是 Object[] 的数组不可以转换成 Employee[]
     */
    static Object arrayGrow(Object obj) {
        Class cls = obj.getClass();
        if (!cls.isArray()) return null;
        Class componentType = cls.getComponentType();
        int length = Array.getLength(obj);
        int newLength = length * 12 / 10 + 10;
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(obj, 0, newArray, 0, length);
        return newArray;
    }
}
