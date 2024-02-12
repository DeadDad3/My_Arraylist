package com.example.myarraylist;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра класса MyArrayList
        MyArrayList<Integer> list = new MyArrayList<>();

        // Проверка метода add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Список после добавления элементов: " + list);

        // Проверка метода get
        int element = list.get(1);
        System.out.println("Элемент с индексом 1: " + element);

        // Проверка метода remove
        list.remove(0);
        System.out.println("Список после удаления элемента: " + list);

        // Проверка метода clear
        list.clear();
        System.out.println("Список после очистки: " + list);

        // Проверка метода size
        int size = list.size();
        System.out.println("Размер списка: " + size);

        // Проверка метода sort
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort(Comparator.naturalOrder());
        System.out.println("Список после сортировки: " + list);

        // Проверка метода quicksort
        list.clear();
        list.add(30);
        list.add(10);
        list.add(20);
        list.quicksort(Comparator.naturalOrder());
        System.out.println("Список после быстрой сортировки: " + list);
    }
}

