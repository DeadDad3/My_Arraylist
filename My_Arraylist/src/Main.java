import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(2, 7);
        System.out.println(list.get(1));
        list.remove(0);
        list.clear();

        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(5);
        myList.add(10);
        myList.add(2, 7);
        System.out.println(myList.get(1));
        myList.remove(0);
        myList.clear();
    }
}