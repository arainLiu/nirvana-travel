package com.nirvana.travel.leetcode.t_0101_200.t_0198_rob;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @date 2022/2/23
 */
public class Solution {

    /**
     * 根据题目，dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 1) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        for (int i = 2; i<length; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}
