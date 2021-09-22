package ch5.corejava;

public class Demo6_Wrapper {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("before triple: " + x);
        triple(x);
        System.out.println("after triple: " + x);
    }

    /**
     * x 虽然是对象，但是 Integer 对象是不可变的。
     */
    private static void triple(Integer x) {
        x = x * 3;
    }
}
