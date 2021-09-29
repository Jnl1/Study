package com.leetcode.string_judge;

public class Demo {
    public static void main(String[] args) {
        String[] str = {"fltyu","flaou","wooiy"};
        System.out.println(method(str));
    }

    public static String method(String[] str) {
       String ref = "";
       int num = 0;
       while (true){
           char c = '\u0000';
           for (String s : str) {
               if (num == str.length) return ref;
               if (c == '\u0000') c = s.charAt(num);
               if (s.charAt(num) != c) return ref;
           }
           ref += c;
           num++;
       }
    }
}

