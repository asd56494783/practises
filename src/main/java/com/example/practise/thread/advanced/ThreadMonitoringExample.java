package com.example.practise.thread.advanced;

public class ThreadMonitoringExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

        try {
            Thread.sleep(2000);
            Thread.State state = thread.getState();
            System.out.println("Thread state: " + state);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Task executing...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

