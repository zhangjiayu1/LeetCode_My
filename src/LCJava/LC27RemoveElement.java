package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/19
 * Time: 21:12
 * Description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class LC27RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        //双指针 慢指针固定，快指针往前扫，不相等的就跟slow交换，
        for (int fast = 0;fast < n;fast++){
            if (val != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    public static int removeElement_1(int[] nums, int val) {
        int n = nums.length;
        int slow = n - 1;
        int fast = 0;
        //同样也是双指针，不过一前一后这样判断，不需要遍历完整个数组，省时间
        while (fast <= slow){
            if(val == nums[fast]){
                nums[fast] = nums[slow];
                slow --;
            }else{
                fast++;
            }
        }
        return fast;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int index = removeElement_1(nums,3);
        for (int i = 0;i < index;i++){
            System.out.println(nums[i]);
        }
    }

}





























