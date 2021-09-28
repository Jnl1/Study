package com.jnl.bigllo;

public class Bigollo {
    public static void main(String[] args) {
        System.out.println(bigollo(65));
        int i = 15;
        int m = 15 >> 1;
        System.out.println(m);
    }

    public static long bigollo(long n){
        if (n <= 1)
            return n;
        long first = 0L;
        long second = 1L;
        for (int i = 0; i < n - 1; i++) {
            long sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static long bigollo2(long n){
        if (n <= 1)
            return n;
        return bigollo2(n - 1) + bigollo2(n - 2);
    }
}
