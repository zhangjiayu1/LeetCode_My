package LCJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/27
 * Time: 23:16
 * Description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 */
public class LC18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //思路跟15题三数之和差不多
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || n < 4){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0;i < n;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //这里少了个nums[i] > target 是因为target不一定为0，可以是任意数
            for (int j = i + 1;j < n;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] +nums[left] + nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]){
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(sum > target){
                        right --;
                    }else {
                        left ++;
                    }
                }
            }
        }
        return result;
    }
}


















