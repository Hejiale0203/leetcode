//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 640 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 两个数组的交集
 *
 * @author hjl
 * @date 2022-10-12 09:09:31
 */
public class P349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
		int[] nums1 = new int[]{1,2,2,1};
		int[] nums2 = new int[]{2,2};
		System.out.println(Arrays.toString(solution.intersection(nums1,nums2)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //哈希 也可以用双指针 需要先排序
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            for (int k : nums1) {
                set.add(k);
            }
            List<Integer> list = new ArrayList<>();
            for (int j : nums2) {
                if (set.contains(j)) {
                    if (!list.contains(j)) {
                        list.add(j);
                    }
                }
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
