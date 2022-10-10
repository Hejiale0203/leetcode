//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 722 👎 0


package leetcode.editor.cn;

/**
 * 搜索二维矩阵
 *
 * @author hjl
 * @date 2022-10-09 16:41:24
 */
public class P74_SearchA2dMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(solution.searchMatrix(matrix, target));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 1) {
                for (int i = 0; i < matrix[0].length; i++) {
                    if(matrix[0][i] == target){
                        return true;
                    }
                }
                return false;
            }
            if(matrix[0].length == 1){
                for (int[] ints : matrix) {
                    if (ints[0] == target) {
                        return true;
                    }
                }
                return false;
            }
            for (int[] ints : matrix) {
                if (ints[matrix[0].length - 1] == target) {
                    return true;
                }
                if (ints[matrix[0].length - 1] > target) {
                    int left = -1;
                    int right = matrix[0].length -1;
                    int mid;
                    while (left < right - 1) {
                        mid = (left + right) / 2;
                        if (ints[mid] == target) {
                            return true;
                        } else if (ints[mid] > target) {
                            right = mid;
                        } else {
                            left = mid;
                        }
                    }
                    return false;

                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
