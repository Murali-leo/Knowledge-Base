package main.java.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        // stack behavior
        deque.push(1000);
        deque.push(2000);

        while (deque.peek() != null) {
            System.out.println(deque.pop());
        }

        // queue behavior
        deque.offer(3000);
        deque.offer(4000);

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }

        // About PriorityQueue
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 22));
        students.add(new Student(3, "Bob", 20));
        students.add(new Student(2, "Charlie", 23));

        // Using Comparable to sort by id
        Queue<Student> studentQueue = new PriorityQueue<>();
        for (Student student : students) {
            studentQueue.offer(student);
        }

        while (studentQueue.peek() != null) {
            System.out.println(studentQueue.poll());
        }

        // using Comparator to sort by age
        Queue<Student> studentQueue2 = new PriorityQueue<>((a, b) -> b.getAge() - a.getAge());
        for (Student student : students) {
            studentQueue2.offer(student);
        }
        
        while (studentQueue2.peek() != null) {
            System.out.println(studentQueue2.poll());
        }
    }

}
