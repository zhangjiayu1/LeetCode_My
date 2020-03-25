package OfferJava;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/3/25 0025
 * Time: 15:12
 * Description:03. 数组中重复的数字 easy
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * 限制：
 * 2 <= n <= 100000
 *
 * 思路：一开始想到的是排序遍历，时间复杂度是O(NlogN)，后来想到可以用set来存放，因为set里是不可以存在重复数据的。
 *      第二个方法是看了题解之后，别人的思路。想法是，如果没有重复数字的话，排完序之后，数字与下标应该是一致的，
 *      所以思路是从头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
 *      在交换过程中，如果有重复的数字发生，那么终止返回数字
 *
 */
public class OF03FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums){
            if(!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static int findRepeatNumber1(int[] nums){
        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumber1(nums));
    }
}
