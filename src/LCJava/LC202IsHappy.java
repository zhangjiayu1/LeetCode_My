package LCJava;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/24
 * Time: 12:58
 * Description:哈希表
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 */
public class LC202IsHappy {
    public int getSquareNum(int n){
        //按位取余求和操作
        int sum = 0;
        while (n > 0){
            int num = n % 10;
            n = n / 10;
            sum += num * num;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        //运用set进行判断
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getSquareNum(n);
        }
        return n == 1;
    }
}





















