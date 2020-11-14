package ru.rybinskov.gb.lesson5.task2;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final int maxWeight;

    private int bestTotalPrice;
    private List<Thing> bestSetOfThings = new ArrayList<>();

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calculateWeight(List<Thing> list) {
        int totalWeight = 0;
        for (int i = 0; i < list.size(); i++) {
            totalWeight += list.get(i).getWeight();
        }
        return totalWeight;
    }

    private int calculatePrice(List<Thing> list) {
        int totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            totalPrice += list.get(i).getPrice();
        }
        return totalPrice;
    }

    private void checkBestSet(List<Thing> items) {
        int totalPrice = calculatePrice(items);
        int totalWeight = calculateWeight(items);
        if (totalWeight <= maxWeight && (bestSetOfThings == null || totalPrice > bestTotalPrice)) {
            bestSetOfThings = items;
            bestTotalPrice = totalPrice;
        }
    }

    public void calculateBestSet(List<Thing> items) {
        if (items.isEmpty()) {
            return;
        }

        checkBestSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Thing> copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            calculateBestSet(copiedItems);
        }
    }

    public List<Thing> getBestSet() {
        return bestSetOfThings;
    }

    public int getBestPrice() {
        return bestTotalPrice;
    }

}
