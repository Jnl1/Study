package com.leetcode.reverse_integer_7;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int head = x % 10;
            int newResult = result * 10 + head;
            if ((newResult - head) / 10 != result){
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
