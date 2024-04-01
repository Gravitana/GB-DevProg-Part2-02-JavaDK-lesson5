package ru.gravitana.homework;

public class Main {
    private final static int COUNT = 5;
    public static void main(String[] args) {
        Object[] forks = new Object[COUNT];
        for (int i = 0; i < COUNT; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < COUNT; i++) {
            int leftForkIndex = i;
            int rightForkIndex = i + 1;
            if (rightForkIndex >= COUNT) {
                rightForkIndex = 0;
            }

            new Thread(new Philosopher(forks[leftForkIndex], forks[rightForkIndex])).start();
        }
    }
}
