package OfferJava;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/06/12
 * Time: 14:38
 * Description:13 机器人的运动范围 medium
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 思路: 跟上一题其实很像，都是考察dfs或者bfs，关键是找到终止条件，以及优化
 */
public class OF13MovingCount {

    public int movingCount(int m, int n, int k) {
        Boolean[][] move = new Boolean[m][n];
        return dfs(0,0,m,n,k,move);
    }

    public int dfs(int i,int j,int m,int n,int k,Boolean move[][]){
        //i j下边越界或者位置上的数字相加大于k，或者为true，表示这里已经走过
        if(i < 0 || i >= m || j < 0|| j >= n || (i/10 + i%10 + j/10 + j%10) > k || move[i][j]){
            return 0;
        }
        //置为true，表明此下标位置已经走过
        move[i][j] = true;
        //
       return dfs(i + 1,j,m,n,k,move) + dfs(i,j + 1,m,n,k,move) + 1;
    }
}
