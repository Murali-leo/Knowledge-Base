package main.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>();
        number.add(10);
        number.add(20);
        number.add(30);

        Iterator<Integer> iterator = number.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // Convert List to Array
        Integer[] arr = number.toArray(new Integer[0]);
        for (Integer num : arr) {   
            System.out.println(num);
        }
        

        // Thread safe List
        List<Integer> vector = new Vector<>();
        vector.add(100);
        vector.add(200);    
        vector.add(300);

        for(Integer num : vector) {
            System.out.println(num);
        }

        List<Integer> ll = new LinkedList<>();
        ll.add(1000);
        ll.add(2000);
        ll.add(3000);

        // ListIterator has next and previous methods
        ListIterator<Integer> listIterator = ll.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
