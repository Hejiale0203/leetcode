//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 1945 👎 0


package leetcode.editor.cn;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author hjl
 * @date 2022-10-11 14:14:10
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{1,4};
        int target = 4;
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length -1;
            int mid;
            if (nums.length == 1) {
                if (nums[0] == target) {
                    return new int[]{0, 0};
                }
            }
            while (left <= right) {
                mid = (left + right) >>> 1;
                if (nums[mid] == target) {
                    int min = mid;
                    int max = mid;
                    while (mid > 0 && nums[mid - 1] == target) {
                        min = mid - 1;
                        mid--;
                    }
                    while (mid < nums.length - 1 && nums[mid + 1] == target) {
                        max = mid + 1;
                        mid++;
                    }
                    return new int[]{min, max};
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
