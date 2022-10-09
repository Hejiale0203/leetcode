//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 5945 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 *
 * @author DY
 * @date 2022-10-09 16:14:13
 */
public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
		int[] nums1 = new int[]{1,3};
		int[] nums2 = new int[]{2,4};
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			double result;
			int[] arr = new int[nums1.length + nums2.length];
			System.arraycopy(nums1, 0, arr, 0, nums1.length);
			System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
			Arrays.sort(arr);
			if(arr.length % 2 == 1){
				result = arr[(arr.length-1) / 2];
			}
			else{
				result =(double)  (arr[(arr.length/2) -1] + arr[arr.length/2]) / 2;
			}

			return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
