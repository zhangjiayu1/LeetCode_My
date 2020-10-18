package LCJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/10/14
 * Time: 16:25
 * Description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class LC239MaxSlidingWindow {

    /**
     *首先直接想到的方法，遍历数组，每个滑动窗口中的其实也是个数组，只需要遍历比较一下就得出结果了
     * 时间复杂度为O(nk) n为数组长度
     * @param nums 数组
     * @param k k值
     * @return 数组
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n * k <= 0){
            return new int[0];
        }
        if(k == 1){
            return nums;
        }
        int[] output = new int[n - k + 1];
        for (int i = 0;i < n - k + 1;i++){
            //不能定义为0是因为可能会有负数
            int max = Integer.MIN_VALUE;
            for (int j = i;j < i + k;j++){
                max = Math.max(max,nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 看了题解之后才知道的双向队列方法
     *
     * @param nums 数组
     * @param k 滑动窗口
     * @return 结果数组
     */
    public static int[] maxSlidingWindow_1(int[] nums,int k){
        int n = nums.length;
        if(n * k <= 0){
            return new int[0];
        }
        if(k == 1){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] output = new int[n - k + 1];
        int j = 0;
        for (int i = 0;i < n;i++){
            if (!queue.isEmpty() && i - queue.peek() >= k){
                queue.pop();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.offer(i);
            if(i >= k - 1){
                if (j < n - k + 1){
                    output[j] = nums[queue.peek()];
                }
                j++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow_1(nums,3);
        for (int i : result){
            System.out.println(i);
        }
    }
}













