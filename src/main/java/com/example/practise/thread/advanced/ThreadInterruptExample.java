package com.example.practise.thread.advanced;

public class ThreadInterruptExample {
    /**
     * 執行緒間的中斷機制，用於向執行緒發出中斷信號，以通知執行緒停止當前的任務並退出或進行相應的處理。
     * 在多執行緒環境中可以控制和處理執行緒的中斷。
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Task executing...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 重新中斷執行緒
                }
            }
            System.out.println("Task interrupted. Exiting...");
        }
    }
}

