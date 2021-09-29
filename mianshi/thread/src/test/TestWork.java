package test;

import java.util.*;

/**
 * @date 2021/9/6
 * @time 21:03
 */
public class TestWork {
    public static void main(String[] args) {
        int[] A = {1,3,5,7,9};
        int[] B = {2,4,6,8,10};
        method(A,B);
    }

    public static void method (int [] a,int[] b){
        int max = 0;
        int arrays[] = new int [a.length + b.length];
        int j = arrays.length - 1;
        for (int i = 0; i < arrays.length; i++) {
            arrays[j--] = b[i];
            if (b.length == (i+1)){
                break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            arrays[j--] = a[i];
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int k = 0; k < arrays.length - i - 1; k++) {
                if (arrays[k] > arrays[k + 1]){
                    max = arrays[k];
                    arrays[k] = arrays[k + 1];
                    arrays[k + 1] = max;
                }
            }
        }
        for (int array : arrays) {
            System.out.print(array + "\t");
        }

        /*System.arraycopy(a,0,arrays,0,5);
        System.arraycopy(b,0,arrays, a.length,5);
        Arrays.sort(arrays);
        for (int array : arrays) {
            System.out.println(array);
        }
        int [] copy = Arrays.copyOf(a, a.length);
        int [] copyTwo = Arrays.copyOfRange(b, a.length-1, b.length);
        for (int i : copy) {
            System.out.println(i);
        }
        System.out.println("----------");
        for (int i : copyTwo) {
            System.out.println(i);
        }*/
    }
}
