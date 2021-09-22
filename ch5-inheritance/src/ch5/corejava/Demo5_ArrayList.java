package ch5.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Demo5_ArrayList {
    public static void main(String[] args) {
        /**
         * ArrayList vs Vector
         *
         * Vector 所有的关键方法中都加了 synchronized，加锁-进方法-结束方法-释放锁，线程安全，开销大。
         * ArrayList 不是线程安全，因此不能在多线程下使用。
         */
        Vector vector = new Vector();
        vector.add(null);

        /**
         * IndexOutOfBoundsException，因为 0 >= list.size
         */
        ArrayList list = new ArrayList();
        list.set(0, null);

        /**
         * insert, remove 效率比较低。对于大的列表，linkedList的效率比较高。
         */

    }
}
