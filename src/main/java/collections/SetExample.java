package main.java.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // Implementation of Set can be added here
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "Alice", 22));
        studentSet.add(new Student(2, "Bob", 20));

        // System.out.println(studentSet);

        NavigableSet<Student> navigableSet = new TreeSet<>((a, b) -> a.getAge() - b.getAge());
        navigableSet.add(new Student(3, "Charlie", 23));    
        navigableSet.add(new Student(1, "Alice", 22));
        navigableSet.add(new Student(2, "Bob", 20));
       System.out.println(navigableSet.higher(new Student(1, "null", 20)));
       System.out.println(navigableSet.ceiling(new Student(1, "null", 20)));

        System.out.println(navigableSet);
    }
}
