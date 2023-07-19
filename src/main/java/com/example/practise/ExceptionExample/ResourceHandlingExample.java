package com.example.practise.ExceptionExample;

import java.io.FileInputStream;
import java.io.IOException;

public class ResourceHandlingExample {
    /**
     * 這個例子展示了使用try-with-resources來自動關閉檔案輸入流。
     * 在try塊內部創建了一個FileInputStream，當程式離開try塊時，
     * 不論是正常結束或是拋出異常，都會自動關閉FileInputStream，
     * 無需額外的finally區塊。
     * @param args
     */
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            // 使用檔案流讀取檔案內容
        } catch (IOException e) {
            System.out.println("無法讀取檔案：" + e.getMessage());
        }
    }
}
