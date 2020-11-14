package ru.rybinskov.gb.lesson5.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Backpack backpack = new Backpack(6);

        List<Thing> list = new ArrayList<>();

        Thing t1 = new Thing("Пауэрбэнг", 1, 2000);
        Thing t2 = new Thing("Фонарь", 1, 1000);
        Thing t3 = new Thing("Термос", 2, 2000);
        Thing t4 = new Thing("Палатка", 4, 5000);
        Thing t5 = new Thing("Книга", 1, 1700);
        Thing t6 = new Thing("Удочки", 2, 3300);
        Thing t7 = new Thing("Подарок", 1, 2800);

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        backpack.calculateBestSet(list);

        System.out.println("Самый дрогой набор на сумму: " + backpack.getBestPrice());

        for (Thing thing : backpack.getBestSet()) {
            System.out.println(thing.getName() + " - " + thing.getPrice());
        }
    }
}
