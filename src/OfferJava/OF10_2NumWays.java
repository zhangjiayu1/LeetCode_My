package OfferJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/20
 * Time: 17:52
 * Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 思路:本质与斐波那契数列是一样的。可以这样推导，假设n级台阶需要f(n)种跳法。跳台阶的最后一步不是跳一级就是跳两级，当跳一级的时候，还剩下n-1级，那此情况共有f(n-1)种跳法
 * 当跳两级的时候，剩n-2个台阶，此情况有f(n-2)种跳法，所以f(n) = f(n-1) + f(n-2)
 */
public class OF10_2NumWays {
    public int numWays(int n){
        int a = 1,b = 1,sum;
        for (int i = 0; i < n;i++){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
