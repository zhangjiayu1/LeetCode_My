package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/10/19
 * Time: 18:11
 * Description:1567. 乘积为正数的最长子数组长度 medium
 *
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 *
 * 示例  1：
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 *
 * 示例 2：
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 *
 * 示例 3：
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 *
 * 示例 4：
 * 输入：nums = [-1,2]
 * 输出：1
 *
 * 示例 5：
 * 输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 *  
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * 思路： 动态规划  定义两个数组 positive表示得到乘积为正数的最长子数组长度，negative表示得到乘积为负数的最长子数组长度。
 *       当i = 0时，num[i] > 0,则为正数，positive[0]初始化为1，当num[i] < 0,则为负数，negative[0]初始化为1，当为0的时候，
 *       positive[0] = negative[0] = 0，表示没有这样的子数组
 *       i > 0 时
 *        当num[i] > 0,并不会更改之前乘积的正负性，所以
 *         positive[i] = positive[i−1]+1
 *         negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
 *        当num[i] < 0,会更改之前乘积的正负性，所以
 *         positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0
 *         negative[i] = positive[i−1]+1;
 *        当num[i] = 0,结果一定为0，所以 positive[i] = negative[i] = 0
 * ​
 */
public class LC1567GetMaxLen {

    public static int getMaxLen(int[] nums) {
        int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,-6,4,0,10};
        System.out.println(getMaxLen(nums));
    }
}
























