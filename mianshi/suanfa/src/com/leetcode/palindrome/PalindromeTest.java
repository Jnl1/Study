package com.leetcode.palindrome;

public class PalindromeTest {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0)
            return false;
        int num = x;
        int rev = 0;
        while (num >= 10){
            rev += num % 10;
            num = num / 10;
            rev = rev * 10;
        }
        rev += num;
        return (x == rev);
    }
}
