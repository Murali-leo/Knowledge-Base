package main.java.multithreads;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    int size;
    Queue<Integer> queue;

    BlockingQueue(int capacity) {
        size = capacity;
        queue = new LinkedList<>();
    }

    public synchronized boolean enqueue(int value) {
        while (queue.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(value);
        notifyAll();
        return true;
    }

    public synchronized int dequeue() {
        while(queue.size() == 0) {
            try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int ele = queue.poll();
        queue.notifyAll();
        return ele;
    }
}
