package ch5.corejava;

public class Demo4_Object {
    public static void main(String[] args) {
        /**
         * 可以作为通用持有者，但是要进行具体的操作，则需要类型转换
         */
        Object object = new Employee(6000, "Helen");
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            employee.getSalary();
        }

        /**
         * 只有基本类型不是对象。
         */

        /**
         * equals vs hashCode
         *
         * we override equals without overriding hashCode, and attempt to use a Map.
         * we have obj1 and obj2 with same value fields, so they are considered as same.
         * 1. only override equals()
         *  - obj1.equals(obj2) return true.
         *  - But map.put(obj1,value) and map.put(obj2,value) will put into two buckets.
         *  - Because obj1.hashCode() is different with obj2.hashCode()
         * 2. only override hashCode()
         *  - obj1.hashCode() == obj2.hashCode(), map.put(obj1,value) and map.put(obj2,value) will put into same bucket.
         *  - but obj1.equals(obj2) return false.
         *
         *  所以两个相等的对象，应该返回相等的 hashCode。
         */

    }
}

/**
 * 有意义地重写 equals 方法。
 */
class School {

    private String name;
    private String address;

    @Override
    public boolean equals(Object obj) {

        // point to same address, they are identical
        if (this == obj) return true;

        // if obj is null
        if (obj == null) return false;

        // if same class
        if (getClass() != obj.getClass()) return false;

        // now confirm the obj is a non-null school
        School otherSchool = (School) obj;
        return name.equals(otherSchool.name) && address.equals(otherSchool.address);

        /**
         * 如果需要在子类中重新定义 equals，先调用 super.equals(other)
         */
    }

    /**
     * 关于 instanceof vs getClass()
     *
     * 在子类中实现 equals，应该使用 getClass，确保对比类不是其他子类。
     * 在父类中实现 equals，使用 instanceof，可以对比不同的对象
     */

}

