package LCJava;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2019/12/25
 * Time: 15:19
 * Description:给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 思路: 题目花里胡哨 数组排序后取奇数位置的数字相加求和
 *
 */
public class LC561ArrayPairSum_1 {

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
}
