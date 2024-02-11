package test.java.com.example.myarraylist;

import main.java.com.example.myarraylist.MyArrayList;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0).intValue());
        assertEquals(20, list.get(1).intValue());
        assertEquals(30, list.get(2).intValue());
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(10, list.get(0).intValue());
        assertEquals(30, list.get(1).intValue());
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testQuicksort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(30);
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(40);
        list.quicksort(Comparator.naturalOrder());
        assertEquals(10, list.get(0).intValue());
        assertEquals(20, list.get(1).intValue());
        assertEquals(30, list.get(2).intValue());
        assertEquals(40, list.get(3).intValue());
        assertEquals(50, list.get(4).intValue());
    }
}