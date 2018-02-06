package com.sourceit.cp;

public class MainCP {

    public static void main(String[] args) {
        Store store = new Store();

        new Thread(() -> {
            try {
                store.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                store.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
