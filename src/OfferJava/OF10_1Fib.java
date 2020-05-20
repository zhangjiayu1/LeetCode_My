package OfferJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/20
 * Time: 16:26
 * Description:10_1 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 思路：一开始想的就是递归，可以得出结果但是缺点是耗时太长，然后参考评论知道了需要用动态规划算法。dp为一堆数组，dp[i]就是想要的结果，然后dp[i] = dp[i-1] + dp[i-2]。
 * 所以我们初始化三个变量，a，b，sum，sum辅助变量使ab交替前进
 */
public class OF10_1Fib {

    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }else {
            return (fib(n-1) + fib(n - 2))%1000000007;
        }
    }

    public static int fib_1(int n){
        int a = 0,b = 1,sum;
        for (int i = 0; i < n;i++){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("fib:" + fib(44) + "耗时：" + (System.currentTimeMillis() - startTime));
        long startTime_1 = System.currentTimeMillis();
        System.out.println("fib_1:" + fib(44) + "耗时：" + (System.currentTimeMillis() - startTime_1));
    }
}
