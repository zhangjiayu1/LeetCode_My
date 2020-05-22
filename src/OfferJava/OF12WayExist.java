package OfferJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/21
 * Time: 17:16
 * Description:12 矩阵中的路径 medium
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 *
 */
public class OF12WayExist {

    public static boolean exist(char[][] board, String word) {
        //string转换为char数组，方便操作
        char[] array = word.toCharArray();
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                if (DFS(board,array,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DFS(char[][] board,char[] word,int i,int j,int k){
        //终止条件判断，i或者j超出边界值 或者矩阵当前的字符与给出的不相同就返回false
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]){
            return false;
        }
        //当k的大小与给出的字符长度减一一致的时候，表明已经全部找到了
        if(k == word.length - 1){
            return true;
        }
        //把当前下标的数值记录下来
        char flag = board[i][j];
        //每走一步就把字符串数组中的字母替换一下，表明这个地方已经走过
        board[i][j] = ' ';
        //使用 || 是因为一旦有一个返回true，剩下的就可以不用再走了
        boolean result = DFS(board,word,i - 1,j,k + 1) || DFS(board,word,i,j + 1,k + 1) ||
                DFS(board,word,i + 1,j,k + 1) || DFS(board,word,i,j - 1,k + 1);
        //回溯，要把之前替换的再换回原来的数值
        board[i][j] = flag;
        return result;
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(array,word));
    }
}
