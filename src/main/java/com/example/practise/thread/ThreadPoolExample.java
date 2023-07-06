package com.example.practise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 建立一個固定大小的執行緒池，有3個執行緒
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 提交任務到執行緒池
        executor.submit(new Task("Task 1"));
        executor.submit(new Task("Task 2"));
        executor.submit(new Task("Task 3"));
        executor.submit(new Task("Task 4"));
        executor.submit(new Task("Task 5"));

        // 關閉執行緒池
        executor.shutdown();
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Task " + name + " is running on " + Thread.currentThread().getName());
            // 執行任務的操作
        }
    }
}

