package com.example.practise.thread;

public class ThreadRaceConditionExample {
    private static int counter = 0;
    private static final int NUM_THREADS = 5;
    private static final int NUM_ITERATIONS = 100000;


    /**
    * 如果incrementCounter沒使用synchronized的話會怎樣?
    **/
    public static void main(String[] args) {
        // 創建多個執行緒並開始執行
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new CounterTask());
            thread.start();
        }

        // 等待所有執行緒完成
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

        private void incrementCounter() {
            int currentValue = counter;
            currentValue++;
            counter = currentValue;
        }
    }
}
