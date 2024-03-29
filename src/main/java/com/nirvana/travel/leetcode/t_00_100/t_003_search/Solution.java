package com.nirvana.travel.leetcode.t_00_100.t_003_search;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * @date 2021/12/27
 *
 */
public class Solution {

  public int search(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
      return -1;
    }

    if (nums.length == 1) {
      return nums[0] == target? 0:-1;
    }

    int left = 0, right = nums.length -1;
    while (left <= right) {
      int mid = (left + right)/2;
      if (nums[mid] == target) {
        return mid;
      }

      //当[0,mid]升序时，
      if (nums[0] <= nums[mid]) {
        if (target >= nums[0] && target < nums[mid]) {
          right = mid -1;
        } else {
          left = mid + 1;
        }
      }
      //当[0，mid]非一直升序，即经过了数组最小值时
      else {
        //此时[mid+1, length -1]上升序，
        // 如果target在[mid+1, length -1]之内
        if (target>nums[mid] && target <= nums[nums.length - 1]) {
          left = mid + 1;
        } else  {
          //如果此时target在[0, mid - 1]上
          right = mid -1;
        }
      }
    }

    return -1;
  }

}
