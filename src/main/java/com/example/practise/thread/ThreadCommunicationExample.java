package com.example.practise.thread;

import java.util.concurrent.Semaphore;

public class ThreadCommunicationExample {
    private static volatile int sharedVariable = 0;
    private static Semaphore semaphore = new Semaphore(1);

    /**
     * 共享變數和訊號量進行執行緒間通訊的例子
     * @param args
     */
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementTask());
        Thread decrementThread = new Thread(new DecrementTask());

        incrementThread.start();
        decrementThread.start();
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();

                for (int i = 0; i < 5; i++) {
                    sharedVariable++;
                    System.out.println("Increment: " + sharedVariable);
                    Thread.sleep(100);
                }

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DecrementTask implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();

                for (int i = 0; i < 5; i++) {
                    sharedVariable--;
                    System.out.println("Decrement: " + sharedVariable);
                    Thread.sleep(100);
                }

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
