package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/18
 * Time: 14:08
 * Description: 二分法
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 思路：由于是排好序的数组，所以查找target的左边界跟target + 1 的左边界即可
 */
public class LC34SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int l = find(nums,target);
        int r = find(nums,target + 1);
        if(l == nums.length || nums[l] != target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r - 1};
    }

    private static int find(int[] nums, int target){
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return left;
    }
}
