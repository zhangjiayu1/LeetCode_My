package LCJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/26
 * Time: 21:27
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */
public class LC15ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if(nums == null || n < 3){
            return result;
        }
        //先进行一下排序
        Arrays.sort(nums);
        for (int i = 0;i < n;i++){
            //如果数组第一个数字就大于0的话，就没有必要继续了，因为一定会大于0
            if(nums[i] > 0){
                break;
            }
            //这里是进行第一步判重操作，用i 跟 i + 1 进行判断会有问题，-1 -1 2 这种答案就会错误，只需要判断当前，而不是去跟后面的比较
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //左指针在i后一位，右指针在末尾
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int num = nums[i] + nums[left] + nums[right];
                if(num == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //这里做去重操作
                    while (left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if (num < 0){
                    //和小于0的话，left需要变大，大于0的话，right就要变小
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
