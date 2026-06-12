package Upskilling.java;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 10 + 5 * 2;          // * before +       → 20
        int b = (10 + 5) * 2;         // () first         → 30
        int c = 10 + 4 / 2 - 1;       // / before + and - → 11
        int d = 2 + 3 * 4 - 8 / 2;    // → 2 + 12 - 4    → 10

        System.out.println("10 + 5 * 2         = " + a + "  (* before +)");
        System.out.println("(10 + 5) * 2       = " + b + "  (() first)");
        System.out.println("10 + 4 / 2 - 1     = " + c + "  (/ before + and -)");
        System.out.println("2 + 3 * 4 - 8 / 2  = " + d + "  (* and / before + and -)");
    }
}