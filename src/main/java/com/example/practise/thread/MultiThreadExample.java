package com.example.practise.thread;

public class MultiThreadExample {
    public static void main(String[] args) {
        // 創建執行緒物件並指定任務
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());

        // 啟動執行緒
        thread1.start();
        thread2.start();

        try {
            // 等待執行緒完成
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }

    // 任務1
    static class Task1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1 executed");
            }
        }
    }

    // 任務2
    static class Task2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 executed");
            }
        }
    }
}

