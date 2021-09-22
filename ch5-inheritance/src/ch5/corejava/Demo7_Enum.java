package ch5.corejava;

public class Demo7_Enum {
    public static void main(String[] args) {

        /**
         * 得到枚举类型的所有枚举值。
         */
        Size[] values = Size.values();
        for (Size value : values) {
            System.out.println(value + " - " + value.getAbbr());
        }
    }
}

enum Size {

    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String abbr;

    /**
     * 构造器只能由自己调用。
     */
    private Size(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}