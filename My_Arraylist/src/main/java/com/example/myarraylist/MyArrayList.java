package main.java.com.example.myarraylist;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс MyArrayList представляет собой реализацию динамического массива.
 * Он позволяет хранить и управлять элементами любого типа данных.
 */
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * Создает экземпляр класса MyArrayList с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить
     */
    public void add(E element) {
        if (size == elements.length) {
            growCapacity();
        }
        elements[size] = element;
        size++;
    }

    /**
     * Добавляет элемент на указанную позицию в списке.
     *
     * @param index   индекс позиции, на которую нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            growCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент на указанной позиции в списке.
     *
     * @param index индекс позиции элемента
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    /**
     * Удаляет элемент на указанной позиции из списка.
     *
     * @param index индекс позиции элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует список с использованием алгоритма быстрой сортировки.
     *
     * @param comparator компаратор для сравнения элементов списка
     */
    public void quicksort(Comparator<? super E> comparator) {
        quicksort(0, size - 1, comparator);
    }

    private void quicksort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами элементы списка на указанных позициях.
     *
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        E temp = get(i);
        elements[i] = get(j);
        elements[j] = temp;
    }

    /**
     * Сортирует список с использованием указанного компаратора.
     *
     * @param comparator компаратор для сравнения элементов списка
     */
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort((E[]) elements, 0, size, comparator);
    }


    /**
     * Возвращает строковое представление списка.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    private void growCapacity() {
        int newCapacity = elements.length + (elements.length / 2);
        elements = Arrays.copyOf(elements, newCapacity);
    }
}