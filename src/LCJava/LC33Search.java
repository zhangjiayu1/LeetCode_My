package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/18
 * Time: 17:02
 * Description:
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 */
public class LC33Search {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //这个地方是这个问题的关键 有序数组旋转后，在mid处分割，总会有一部分是有序的,一部分是无序的，在有序部分中查找。如果不存在，则将无序部分再次二分，继续去有序的部分查找
            //nums[mid] < nums[right] 表示[mid + 1,right]这一段中数字是有序的，此时需要判断target在不在这个区间内 也就是 nums[mid] < target < = nums[right]
            if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            //nums[mid] > nums[right] 表示[left,mid]这一段中数字是有序的，此时需要判断target在不在这个区间内 也就是 nums[left] <= target < nums[mid]
            else{
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }

    public static int search_1(int[] nums, int target){
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
