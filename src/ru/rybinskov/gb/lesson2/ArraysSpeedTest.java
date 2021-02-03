package ru.rybinskov.gb.lesson2;

public class ArraysSpeedTest {
    public static int arraySize = 100_000;

    public static void main(String[] args) {
        Array<Integer> arrayForBubbleSort = new ArrayImpl<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            arrayForBubbleSort.add((int) (Math.random() * 10_000));
        }
        Array<Integer> arrayForSortSelect = arrayForBubbleSort.clone();
        Array<Integer> arrayForSortInsert = arrayForBubbleSort.clone();

        //тестил вывод с 10 значениями в массивах
//        System.out.print("arrayForBubbleSort : ");
//        arrayForBubbleSort.display();
//        System.out.print("arrayForSortInsert : ");
//        arrayForSortInsert.display();
//        System.out.print("arrayForSortSelect : ");
//        arrayForSortSelect.display();

        System.out.println("Тест начался!");

        checkTimeForBubbleSort(arrayForBubbleSort);

//        System.out.print("arrayForBubbleSort : ");
//        arrayForBubbleSort.display();
//        System.out.print("arrayForSortInsert : ");
//        arrayForSortInsert.display();
//        System.out.print("arrayForSortSelect : ");
//        arrayForSortSelect.display();

        checkTimeForSortInsert(arrayForSortInsert);

//        System.out.print("arrayForBubbleSort : ");
//        arrayForBubbleSort.display();
//        System.out.print("arrayForSortInsert : ");
//        arrayForSortInsert.display();
//        System.out.print("arrayForSortSelect : ");
//        arrayForSortSelect.display();

        checkTimeForSortSelect(arrayForSortSelect);

//        System.out.print("arrayForBubbleSort : ");
//        arrayForBubbleSort.display();
//        System.out.print("arrayForSortInsert : ");
//        arrayForSortInsert.display();
//        System.out.print("arrayForSortSelect : ");
//        arrayForSortSelect.display();

    }

    public static void checkTimeForBubbleSort(Array<?> array) {
        long startTime = System.currentTimeMillis();
        array.sortBubble();
        System.out.println("Сортировка пузырьком отработала за " + (System.currentTimeMillis() - startTime));
    }

    public static void checkTimeForSortSelect(Array<?> array) {
        long startTime = System.currentTimeMillis();
        array.sortSelect();
        System.out.println("Сортировка методом выбора отработала за " + (System.currentTimeMillis() - startTime));
    }

    public static void checkTimeForSortInsert(Array<?> array) {
        long startTime = System.currentTimeMillis();
        array.sortInsert();
        System.out.println("Сортировка методом вставки отработала за " + (System.currentTimeMillis() - startTime));
    }
}

