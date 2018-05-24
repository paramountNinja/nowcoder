package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to TrieTree specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class _1TwoSum {
    //time O(n^2) space O(1)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //time O(n) space O(n) two-pass
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i)
                return new int[]{i, map.get(key)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //time O(n) space O(n) one-pass：一边查找，一边存key-value
    public int[] twoSum_3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i)
                return new int[]{i, map.get(key)};
            //若不存在，将当前值存入
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*
思路：key-value：数值-下标
 */