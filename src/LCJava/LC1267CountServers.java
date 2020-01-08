package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/01/08
 * Time: 14:46
 * Description:1267. 统计参与通信的服务器 medium
 *
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * 示例 1：
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 *
 * 示例 2：
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 *
 * 示例 3：
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *  
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * 思路：读题得知只要在同一行或者同一列就可以进行通信，那如果(x,y)处的服务器能至少与一台其他服务器进行通讯，那么第x行至少有一台服务器，或者第y列至少有一台
 * 所以我们先进行遍历，用数组记录每一行每一列的服务器的数量。统计完之后再遍历，如果在(x,y)处有一台服务器保证row[x] > 1或者col[y] > 1则满足条件。
 */
public class LC1267CountServers {

    public static int countServers(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 0){
                    continue;
                }
                row[i]++;
                col[j]++;
            }
        }
        int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)){
                    result ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,0},{0,1}};
        int[][] grid2 = new int[][]{{1,0},{1,1}};
        int[][] grid3 = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid1));
        System.out.println(countServers(grid2));
        System.out.println(countServers(grid3));
    }
}
