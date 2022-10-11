//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。 
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 53 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Handler;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author hjl
 * @date 2022-10-11 09:12:43
 */
public class P1790_CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1790_CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(solution.areAlmostEqual(s1, s2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            HashMap<Integer, Character> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                map.put(i, s1.charAt(i));
            }
            int firstIndex = 0;
            int secondIndex = 0;
            char[] arr = new char[s2.length()];
            int count = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (!map.get(i).equals(s2.charAt(i))) {
                    count++;
                    if (count == 1) {
                        firstIndex = i;
                    } else if (count == 2) {
                        secondIndex = i;
                    } else {
                        return false;
                    }
                }
                arr[i] = s2.charAt(i);
            }
            char ans = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = ans;
            return Arrays.equals(arr,s1.toCharArray());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
