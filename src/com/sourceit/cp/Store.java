package com.sourceit.cp;

import java.util.LinkedList;

public class Store {
    LinkedList<Integer> store = new LinkedList<>();
    Object lock = new Object();

    public void produce() throws InterruptedException {
        int goods = 0;

        while (true) {
            synchronized (lock) {
                if (store.size() > 10) {
                    System.out.println("Producer is sleeping");
                    lock.wait();
                    System.out.println("Producer awake");
                }
                store.add(goods);
                goods++;
                System.out.println("produce="+goods);

                lock.notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (store.size() == 0) {
                    System.out.println("Consumer is sleeping");
                    lock.wait();
                    System.out.println("Consumer awake");
                }

                int goodFromStore = store.remove();
                System.out.println("consume=" + goodFromStore);

                lock.notifyAll();
            }
        }
    }
}
