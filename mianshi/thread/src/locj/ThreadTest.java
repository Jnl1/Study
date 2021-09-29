package locj;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/8/10
 * @time 22:02
 */
public class ThreadTest {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ints = toSum(nums, 18);
        for(int num : ints){
            System.out.println(num);
        }

    }

    private static int[] toSum (int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int num = target - nums[i];
           if (map.containsKey(num)){
               return new int[] {map.get(num),i};
           }
           map.put(nums[i],i);
        }
       throw new IllegalArgumentException("not found");
    }

    public static int compare(int a, int b){
        int diff = a ^ b;
        if( diff == 0)
            return a;
        diff = diff | ( diff >> 1 );
        diff |= diff >> 2;
        diff |= diff >> 4;
        diff |= diff >> 8;
        diff |= diff >> 16;
        diff ^= diff >> 1;
        return  ( (a & diff) == 0 )  ? -1 : 1;
    }
}
