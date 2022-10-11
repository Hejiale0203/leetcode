//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1588 👎 0


package leetcode.editor.cn;

import leetcode.DTO.TreeNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author hjl
 * @date 2022-10-11 11:12:11
 */
public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode();
        TreeNode left = new TreeNode(2,left1,right1);
        TreeNode right = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1,left,right);
        System.out.println(solution.inorderTraversal(treeNode));

    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
