package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/18
 * Time: 13:10
 * Description:35 搜索插入位置 easy
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 思路： 见下文注释
 */
public class LC35SearchInsert {

    public static int searchInsert(int[] nums,int target){
        //当数组中存在这个数字时，[left,right]表示的就是target在这个数组中的区间，当left == right == mid时，返回的mid就是此时要的target下标
        //其实这里省略了一个判断就是target == nums[mid]时返回mid。
        //左右闭区间 其实不大好理解 这个题目抽象出来就是查找第一个大于等于target的数字的下标 target小于nums[mid]的情况下，其实mid所在的位置可能就是第一个
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < target){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static int search_1(int[] nums,int target){
        int n = nums.length;
        int left = 0;
        // 我们定义target在左闭右闭的区间里，[left, right]，这个区间的定义就是我们的不变量，接下来，要在下面的循环中，坚持这个不变量，我们就知道其中的边界条件应该怎么判断了
        int right = n - 1;
        // 为什么是<=呢，因为当left==right，区间[left, right]依然有效
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                // target 在左区间，因为我们的区间是左闭右闭的区间，nums[middle]一定不是我们的目标值，所以在right = middle - 1在[left, middle - 1]区间中继续寻找目标值
                right = middle - 1;
            } else if (nums[middle] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else { // nums[middle] == target
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前，此时区间为[0, -1]，所以return right + 1
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置，一定是我们查找的范围 [left, right]之后，return  right + 1
        // 目标值在数组所有元素之后的情况，也是我们查找的范围 [left, right]之后， return right + 1
        return right + 1;
    }

    public static int search_2(int[] nums,int target){
        int n = nums.length;
        int left = 0;
        // 我们定义target在左闭右开的区间里，[left, right)  这是因为left == right的时候，在[left, right)是无效的空间
        int right = n;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                // target 在左区间，因为是左闭右开的区间，nums[middle]一定不是我们的目标值，所以right = middle，在[left, middle)中继续寻找目标值
                right = middle;
            } else if (nums[middle] < target) {
                // target 在右区间，在 [middle+1, right)中
                left = middle + 1;
            } else {
                // target 在右区间，在 [middle+1, right)中
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前，此时区间为 [0,0)，所以可以return right
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
}
