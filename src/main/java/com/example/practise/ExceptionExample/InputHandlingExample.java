package com.example.practise.ExceptionExample;

import java.util.Scanner;

public class InputHandlingExample {
    /**
     * 這個例子中，使用try-catch來處理從鍵盤輸入整數時可能出現的無效輸入。
     * 如果使用者輸入了非整數的字元，nextInt()方法會拋出InputMismatchException，
     * 這時程式會進入catch區塊並輸出錯誤訊息。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("請輸入一個整數：");
            int num = scanner.nextInt();
            System.out.println("您輸入的數字是：" + num);
        } catch (java.util.InputMismatchException e) {
            System.out.println("輸入無效，請輸入一個有效的整數。");
        }
    }
}
