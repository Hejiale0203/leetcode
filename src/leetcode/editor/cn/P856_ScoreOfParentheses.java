//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 406 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 括号的分数
 *
 * @author hjl
 * @date 2022-10-09 17:48:27
 */
public class P856_ScoreOfParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P856_ScoreOfParentheses().new Solution();
		String s = "(())";
		System.out.println(solution.scoreOfParentheses(s));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
		/**
		 * 利用栈的特性 先进后出
		 * 类似 四则运算法则
		 * 如果左括号碰到右括号 拿出来 1
		 * 如果左括号碰到左括号 2*1
		 *
		 */
        public int scoreOfParentheses(String s) {
			Deque<Integer> list = new ArrayDeque<>();
			list.addLast(0);
			for (char c : s.toCharArray()) {
				if(c == '(') {
					list.addLast(0);
				}
				else if(c == ')'){
					int cur = list.pollLast();
					list.addLast(list.pollLast() + Math.max(cur * 2 , 1));
				}
			}
			return list.peekLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
