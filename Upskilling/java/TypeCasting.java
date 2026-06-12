package Upskilling.java;

public class TypeCasting {
    public static void main(String[] args) {
        // double to int
        double d = 9.99;
        int fromDouble = (int) d;
        System.out.println("double " + d + " cast to int: " + fromDouble);

        // int to double
        int i = 42;
        double fromInt = (double) i;
        System.out.println("int " + i + " cast to double: " + fromInt);
    }
}