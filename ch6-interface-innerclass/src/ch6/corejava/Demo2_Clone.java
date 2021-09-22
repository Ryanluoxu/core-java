package ch6.corejava;

import java.util.Date;

public class Demo2_Clone {
    public static void main(String[] args) {
        /**
         * 如果原始对象，与浅克隆对象共享的子对象是不可变的，就没问题。比如 String。
         * 否则，需要进行深克隆。
         *
         * 思考：
         *  1 默认的 clone 是否满足
         *  2 默认的 clone 是否可以通过调用子对象的 clone 来修补。
         *
         * 也可以使用序列化来实现，简单安全，但效率较低。
         */
    }
}

/**
 * clone 方法是从 Object 继承而来，而不是 Cloneable。
 * Cloneable 只是一个标记接口，表明设计者知道要进行 clone 处理。
 * 使用标记接口的唯一目的就是：可以用 instanceof 进行类型检查。
 */
class Company implements Cloneable {

    private String name;
    private Date startDate;

    /**
     * raise to public, change return type.
     */
    @Override
    public Company clone() throws CloneNotSupportedException {
        // call object.clone
        Company company = (Company) super.clone();

        // clone mutable field
        company.startDate = (Date) startDate.clone();

        return company;
    }
}
