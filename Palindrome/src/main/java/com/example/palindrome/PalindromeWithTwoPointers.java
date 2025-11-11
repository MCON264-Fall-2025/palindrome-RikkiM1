package com.example.palindrome;

public final class PalindromeWithTwoPointers {
    private PalindromeWithTwoPointers() { /* utility */ }

    /**
     * Determines if a string is a palindrome using the two-pointer technique.
     * Ignores case and non-alphanumeric characters.
     *
     * @param s input string (must not be null)
     * @return true if the string is a palindrome, false otherwise
     * @throws IllegalArgumentException if s is null
     */
    public static boolean isPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("Input cannot be null");

        String cleaned = normalize(s);
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String normalize(String s) {
        if (s == null) throw new IllegalArgumentException("Input cannot be null");
        return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }
}