package cn.krislin.swordoffer;

import java.util.*;

/**
 * 题目描述
 *      找出数组中重复的数字。
 *
 *      在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 *      2 <= n <= 100000
 *
 * 题目样例
 *      输入
 *      [2, 3, 1, 0, 2, 5, 3]
 *
 *      输出
 *      2 或 3
 *
 *
 * @author krislin
 * @date 2021/4/9 17:29
 */
public class Question03 {

    public static int[] arrayRepeatedNumbers(int[] array) {
        List<Integer> result = new ArrayList<>();
        /**
         * key:    数组中的数字
         * value:  数字出现的次数
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        map.forEach((key, val) -> {
            if (val >= 2) {
                result.add(key);
            }
        });

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        int[] repeatedNumbers = arrayRepeatedNumbers(array);

        Arrays.stream(repeatedNumbers).forEach(System.out::println);
    }
}
