package org.example;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static boolean checkForPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Null veya boş bir string palindrome değildir
        }

        // Girdi metni temizleniyor: alfanümerik karakterler dışındaki her şey kaldırılıyor
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Deque kullanılarak çift uçtan palindrome kontrolü
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleanedInput.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false; // Karakterler eşleşmiyorsa palindrome değildir
            }
        }

        return true; // Karakterler uyumluysa palindrome'dur
    }

    public static String convertDecimalToBinary(int number) {
        if (number == 0) {
            return "0"; // 0'ın binary gösterimi "0"dır
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder binaryString = new StringBuilder();

        // Sayıyı 2'ye bölerek kalanları stack'e ekle
        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        // Stack'ten çıkararak binary string oluştur
        while (!stack.isEmpty()) {
            binaryString.append(stack.pop());
        }

        return binaryString.toString();
    }
}