package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/01/07
 * Time: 14:36
 * Description:1007. 行相等的最少多米诺旋转 medium
 *
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 *
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 *
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 *
 * 如果无法做到，返回 -1.
 *
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2
 *
 * 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
 * 输出：-1
 * 解释：
 * 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 *  
 * 提示：
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 *
 * 思路:贪心算法
 *
 * 如果要满足第 1 种或是第 2种情况，就必须存在一块多米诺骨牌，它的上半部分或者下半部分的数字 x 在所有其它的多米诺骨牌中都出现过。
 *
 * 若该条件满足，则说明所有多米诺骨牌中都出现了数字 x。因此，我们只要选择任意一块多米诺骨牌，判断它的上半部分或下半部分的数字是否可以作为 x 即可。
 *
 * 选择第一块多米诺骨牌，它包含两个数字 A[0] 和 B[0]；
 *
 * 检查其余的多米诺骨牌中是否出现过 A[0]。如果都出现过，则求出最少的翻转次数，其为将 A[0] 全部翻到 A 和全部翻到 B 中的较少的次数。
 *
 * 检查其余的多米诺骨牌中是否出现过 B[0]。如果都出现过，则求出最少的翻转次数，其为将 B[0] 全部翻到 A 和全部翻到 B 中的较少的次数。
 *
 * 如果上述两次检查都失败，则返回 -1。
 */
public class LC1007MinDominoRotations {

    public static int minDominoRotations(int[] A,int[] B){
        int n = A.length;
        int rotations = check(A[0],A,B,n);
        if(rotations != -1 || A[0] == B[0]){
            return rotations;
        }else {
            return check(B[0],A,B,n);
        }
    }

    private static int check(int x,int[] A,int[] B,int n){
        int rotations_a = 0,rotations_b = 0;
        for (int i = 0;i < n;i++){
            if(A[i] != x && B[i] != x){
                return -1;
            }else if(A[i] != x){
                rotations_a ++;
            }else if (B[i] != x){
                rotations_b ++;
            }
        }
        return Math.min(rotations_a,rotations_b);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,2,4,2,2};
        int[] b = new int[]{5,2,6,2,3,2};
        int[] c = new int[]{3,5,1,2,3};
        int[] d = new int[]{3,6,3,3,4};
        System.out.println(minDominoRotations(a,b));
        System.out.println(minDominoRotations(c,d));
    }
}
