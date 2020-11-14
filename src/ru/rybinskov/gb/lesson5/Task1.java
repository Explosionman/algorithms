package ru.rybinskov.gb.lesson5;

public class Task1 {
    public static void main(String[] args) {

        System.out.println("2 в 3: " + elevate(2, 3));
        System.out.println("2 в 0: " + elevate(2, 0));
        System.out.println("2 в -2: " + elevate(2, -2));
        System.out.println("0 во 2: " + elevate(0, 2));
        System.out.println("0 в -2: " + elevate(0, -2));

    }

    public static double elevate(double digit, int degree) {
        if (digit == 0) {
            if (degree > 0) return 0;
            else throw new IllegalArgumentException("Не имеет смысла");
        }
        if (degree < 0) {
            return 1 / (digit * elevate(digit, -degree - 1));
        }
        if (degree > 0) return digit * elevate(digit, degree - 1);
        else return 1;
    }
}
