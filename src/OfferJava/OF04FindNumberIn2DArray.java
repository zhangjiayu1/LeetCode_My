package OfferJava;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/3/31 0031
 * Time: 17:13
 * Description: 04. 二维数组中的查找 easy
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 思路：暴力方法是直接遍历二维数组，挨个判断。时间复杂度为O(m*n)
 * 题目中给出的二维数组是排好序的，从左到右从上到下递增，那么我们就可以从右上角开始判断，target比这个数字大的话，可得这一排中的数字都比target小
 * 我们就可以移动到下一行，如果target比这个数字小，我们就左移到上一列，以此循环，最后得到答案时间复杂度O(m+n)因为最多执行m+n次
 */
public class OF04FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length,n = matrix[0].length;
        int row = 0,col = n - 1;
        while (row < m && col >= 0){
            if(matrix[row][col] > target){
                col--;
            }else if(matrix[row][col] < target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println("target = 5:"+findNumberIn2DArray(matrix,5));
        System.out.println("target = 20:"+findNumberIn2DArray(matrix,20));
    }
}
