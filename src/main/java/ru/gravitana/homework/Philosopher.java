package ru.gravitana.homework;

public class Philosopher implements Runnable {

    private static int lastId = 0;
    private final int id;
    private int countEating = 0;

    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        lastId++;
        this.id = lastId;

        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (countEating < 3) {
            try {
                toDo("thinking");

                synchronized (leftFork) {
                    toDo("take Left");
                    synchronized (rightFork) {
                        toDo("take Right");
                        toDo("eating " + (++countEating) + " times");
                        toDo("puts Right");
                    }
                    toDo("puts Left");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    private void toDo(String action) throws InterruptedException {
        System.out.println("Philosopher " + id + " " + action);
//        Thread.sleep(100);
    }

//    private void takeLeft() {
//        System.out.println("Philosopher " + id + " take Left");
//    }
//
//    private void takeRight() {
//        System.out.println("Philosopher " + id + " take Right");
//    }
//
//    private void eating() {
//        System.out.println("Philosopher " + id + " eating");
//    }
//
//    private void putsLeft() {
//        System.out.println("Philosopher " + id + " puts Left");
//    }
//
//    private void putsRight() {
//        System.out.println("Philosopher " + id + " puts Right");
//    }
}
