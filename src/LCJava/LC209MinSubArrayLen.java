package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/19
 * Time: 21:41
 * Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 */
public class LC209MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int len = nums.length;
        int j=0;
        int sum = 0;
        for (int i = 0;i < len;i++){
            //先把数组中的数字不断相加，得到sum
            sum+=nums[i];
            //i跟j构造滑动窗口 j作为窗口的起始位置，i为结束位置
            while (target <= sum){
                result = Math.min(result,(i - j + 1));
                //当target大于sum的时候，这一步是用来缩减窗口长度的
                //当target等于sum的时候，通过这一步得到改变后的sum跳出while循环，得到最终的结果
                sum-=nums[j++];
                //j++ 先赋值再++所以两步合二为一
                //j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
