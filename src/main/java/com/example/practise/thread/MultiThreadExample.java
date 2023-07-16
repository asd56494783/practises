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




//    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int numThreads = 4;
//
//        int chunkSize = numbers.length / numThreads;
//
//        SumCalculator[] calculators = new SumCalculator[numThreads];
//        Thread[] threads = new Thread[numThreads];
//
//        // 創建並啟動計算執行緒
//        for (int i = 0; i < numThreads; i++) {
//            int startIndex = i * chunkSize;
//            int endIndex = (i == numThreads - 1) ? numbers.length : (i + 1) * chunkSize;
//
//            calculators[i] = new SumCalculator(numbers, startIndex, endIndex);
//            threads[i] = new Thread(calculators[i]);
//            threads[i].start();
//        }
//
//        // 等待所有計算執行緒完成
//        try {
//            for (Thread thread : threads) {
//                thread.join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 計算總和
//        int totalSum = 0;
//        for (SumCalculator calculator : calculators) {
//            totalSum += calculator.getSum();
//        }
//
//        System.out.println("Total sum: " + totalSum);
//    }
//
//    static class SumCalculator implements Runnable {
//        private int[] numbers;
//        private int startIndex;
//        private int endIndex;
//        private int sum;
//
//        public SumCalculator(int[] numbers, int startIndex, int endIndex) {
//            this.numbers = numbers;
//            this.startIndex = startIndex;
//            this.endIndex = endIndex;
//        }
//
//        @Override
//        public void run() {
//            sum = 0;
//            for (int i = startIndex; i < endIndex; i++) {
//                sum += numbers[i];
//            }
//        }
//
//        public int getSum() {
//            return sum;
//        }
//    }
}

