/**
 * 题目Id：46
 * 题目：全排列
 * 日期：2023-01-10 08:45:02
 */
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2358 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P46_Permutations {
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            //定义一个哈希
            HashMap<Integer, Integer> map = new HashMap<>(16);
            int count = 0;
            while (count < nums.length * nums.length - 1) {
                //全排列
                for (int i = 0; i < nums.length; i++) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    if (!map.containsKey(nums[i])) {
                        map.put(i, nums[i]);
                    }
                    list.add(subList);
                    /**
                     * 需要变换nums中的元素 继续遍历
                     */
                    count ++ ;
                }
            }

            for (Integer keySet : map.keySet()) {
                System.out.println(keySet);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 