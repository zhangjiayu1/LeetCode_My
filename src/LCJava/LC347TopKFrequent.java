package LCJava;/**
 * Created with IntelliJ IDEA.
 *
 * @author : 11568
 * @date : 2021/05/15
 * Time : 15:28
 * Description:
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 11568
 * @date : 2021/05/15
 * Time : 15:28
 * Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *  
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class LC347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int length = nums.length;
        if(k > length){
            return result;
        }
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        //使用linkedHashMap的原因是，linkedHashMap是有顺序的，依照key值存入的顺序来存放
        Map<Integer,Integer> map1 = new LinkedHashMap<>();
        //每个键值对都被看做是一个set集合
        map.entrySet()
                .stream()
                //对任意两个键值对进行排序，排序的条件是value，compareTo方法是比较
                .sorted((p1,p2) -> p2.getValue().compareTo(p1.getValue()))
                //最后以list形式进行输出
                .collect(Collectors.toList())
                //对于每一个键值对flag，取他的key跟value放入到map1中
                .forEach(flag -> map1.put(flag.getKey(),flag.getValue()));
        for (Integer key : map1.keySet()){
            if(j == k){
                continue;
            }
            result[j] = key;
            j++;
        }
        return result;
    }

}

































