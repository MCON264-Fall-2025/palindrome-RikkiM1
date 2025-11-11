package com.example.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeWithStackQueue {

    /**
     * Uses a Stack and a Queue to determine if a string is a palindrome.
     * Ignores case and non-alphanumeric characters.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        // Normalize input
        StringBuilder candidate = new StringBuilder(normalize(s));
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push and enqueue all characters
        for (char ch : candidate.toString().toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }

        // Compare characters popped/dequeued
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }

    // Helper normalization method for tests
    public static String normalize(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}