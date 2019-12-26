package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2019/12/26
 * Time: 18:00
 * Description:560.和为k的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 思路：直接想到的就是暴力(貌似我也只能想到这个了),循环遍历相加比较，等于k就加一，简单暴力，但是数据量大了肯定花的时间长
 */
public class LC560SubarraySum {

    public static int subarraySum(int[] nums,int k){
        int count = 0;
        for (int start = 0;start < nums.length;start++){
            int sum = 0;
            for (int end = start;end < nums.length;end++){
                sum += nums[end];
                if(sum == k){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum(nums,2));
    }
}
