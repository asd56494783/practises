package com.example.practise.thread.advanced;

import java.util.concurrent.*;

public class ThreadPoolRejectionPolicyExample {
    /**
     * 執行緒池的拒絕策略是在執行緒池無法接受新的任務
     * @param args
     */
    public static void main(String[] args) {
        int numThreads = 3;
        int maxTasks = 5;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(numThreads, numThreads, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(maxTasks), new CustomRejectedExecutionHandler());

        for (int i = 0; i < maxTasks + 2; i++) {
            executor.submit(new Task("Task " + (i + 1)));
        }

        executor.shutdown();
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing " + name + " on " + Thread.currentThread().getName());
        }
    }

    static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + ((Task) r).name + " rejected. Applying custom rejection policy.");
        }
    }
}

