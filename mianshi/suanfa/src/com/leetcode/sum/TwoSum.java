package com.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/8/8
 * @time 21:01
 */
public class TwoSum{
    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int[] ints = twoSum1(array,9);
        for(int i : ints){
            System.out.println(i);
        }
    }

    public static int[] twoSum1(int [] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = target - nums[i];
            if (map.containsKey(num)){
                return new int[] {map.get(num),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not number");
    }
}
