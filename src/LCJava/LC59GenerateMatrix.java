package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/20
 * Time: 21:02
 * Description:
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class LC59GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int max = n * n;
        int[][] matrix = new int[n][n];
        int rows = 0,column = 0;
        //定义四个方向 右 下 左 上
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int num = 1;
        int directIndex = 0;
        while (num <= max){
            matrix[rows][column] = num;
            num++;
            //行 一开始向右，所以行不变
            int newRows = rows + direct[directIndex][0];
            //列 列+1
            int newColumn = column + direct[directIndex][1];
            //判断边界问题以及当前位置有没有数
            if(newRows < 0 || newRows >= n || newColumn < 0 || newColumn >= n || matrix[newRows][newColumn] != 0){
                //在转完一圈后继续转就需要进行取余了
                directIndex = (directIndex + 1) % 4;
                //directIndex ++;
            }
            //上面判断通过后就把真正的值加上
            rows += direct[directIndex][0];
            column += direct[directIndex][1];
        }
        return matrix;
    }
}
