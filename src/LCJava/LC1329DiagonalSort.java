package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/10/21
 * Time: 14:59
 * Description:
 *
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。

 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class LC1329DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int k = 0;k < Math.min(m,n);k++){
            for (int i = 0;i < m - 1;i++){
                for (int j = 0;j < n -1;j++){
                    if(mat[i][j] > mat[i + 1][j + 1]){
                        int temp = mat[i][j];
                        mat[i][j] = mat[i + 1][j + 1];
                        mat[i + 1][j + 1] = temp;
                    }
                }
            }
        }
        return mat;
    }
}
