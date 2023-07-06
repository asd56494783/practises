package com.example.practise.thread.advanced;

public class ThreadPriorityExample {
    /**
     * 執行緒優先級（Thread Priority）是用於指定執行緒在競爭資源時的調度優先級。每個執行緒都有一個優先級，用於指示其相對於其他執行緒的重要性和調度順序。
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Task 1"));
        Thread thread2 = new Thread(new Task("Task 2"));

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " executing on " + Thread.currentThread().getName());
        }
    }
}

