package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2021/9/1
 * @time 10:33
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int key = 3;
        map.computeIfAbsent(key, Integer -> new ArrayList<>());
        map.get(key).add(1);
        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }
    }
}
