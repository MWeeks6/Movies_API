package com.example.movies_api;

public class ThreadTesting {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 1; i <= 5; i++){
                System.out.printf("Thread: %s count: %d%n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        //Create Thread Objects
        Thread thread1 = new Thread(run, "Thread 1");
        Thread thread2 = new Thread(run, "Thread 2");
        Thread thread3 = new Thread(run, "Thread 3");
        Thread thread4 = new Thread(run, "Thread 4");
        Thread thread5 = new Thread(run, "Thread 5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
