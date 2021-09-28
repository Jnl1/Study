package test;

import java.util.stream.Stream;

/**
 * @date 2021/8/31
 * @time 15:44
 */
public class TestLeet {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(removeDuplicates(nums));
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        
    }

    public static int removeDuplicates(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0;
        for (int right = 0; right < array.length; right++) {

            if (array[left] != array[right]){
                array[++left] = array[right];
            }
        }
        return ++left;
    }
}
