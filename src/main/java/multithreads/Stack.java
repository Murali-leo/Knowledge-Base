package main.java.multithreads;

public class Stack {

    int[] arr;
    int top;
    int size;
    Object lock;

    Stack(int capacity) {
        size = capacity;
        arr = new int[size];
        top = -1;
        lock = new Object();
    }

    // synchronized method to make it thread-safe
    public synchronized boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        arr[++top] = value;
        return true;
    }
    
    // synchronized method to make it thread-safe
    public int pop() {
        synchronized (lock) {
            if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE; // sentinel - no element to return
        }
        int ele = arr[top];
        arr[top] = Integer.MIN_VALUE; // optional: clear slot
        top--;
        return ele;
        }
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=top; i++) {
            sb.append(arr[i] + " ");
        }
        return sb.toString();
    }
    
}
