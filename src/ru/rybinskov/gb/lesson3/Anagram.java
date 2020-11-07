package ru.rybinskov.gb.lesson3;

import ru.rybinskov.gb.lesson3.MyStack.Stack;
import ru.rybinskov.gb.lesson3.MyStack.StackImpl;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        System.out.println("Введите любое слово и нажмите enter:");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        Stack<Character> characterStack = new StackImpl<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            characterStack.push(word.charAt(i));
        }

        printAnswer(characterStack);
    }

    private static void printAnswer(Stack<Character> characterStack) {
        while (!characterStack.isEmpty()) {
            System.out.print(characterStack.pop());
        }
    }
}
