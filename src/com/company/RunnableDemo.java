package com.company;

public class RunnableDemo implements Runnable {
    private Thread t;
    private final String threadName;

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread "+threadName+" interrupt.");
        }
        System.out.println("Thread "+threadName+"exiting.");
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating" + threadName);
    }
}
