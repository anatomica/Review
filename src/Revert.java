public class Revert {

    public static void main(String[] args) {
        revert();
    }

    private static void revert() {
        int a = 123;
        int b = 321;
        System.out.println("a = " + a + " b = " + b);
        // a = 123 b = 321

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
        // a = 321 b = 123

        int c = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        System.out.println("c = " + c + " d = " + d);
        // c = -2147483648 d = 2147483647

        c = c + d;
        d = c - d;
        c = c - d;
        System.out.println("c = " + c + " d = " + d);
        // Будет ли реверс значений?
    }

}
