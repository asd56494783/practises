package com.example.practise.thread;

public class ThreadSyncExample {
    private static int counter = 0;
    private static final int NUM_THREADS = 5;
    private static final int NUM_ITERATIONS = 100000;

    public  static void main(String[] args) {
        for (int i =0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new CounterTask());
            thread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }

    static class CounterTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                incrementCounter();
            }
        }
        private synchronized void incrementCounter() {
            counter++;
        }

    }
}
