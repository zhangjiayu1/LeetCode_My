package LCJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/22
 * Time: 22:34
 * Description: 哈希表
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class LC349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        //放set中进行判断 没啥好说的
        Set<Integer> set_1 = new HashSet<>();
        Set<Integer> set_2 = new HashSet<>();
        for (int num : nums1){
            set_1.add(num);
        }
        for (int num : nums2){
            if (set_1.contains(num)){
                set_2.add(num);
            }
        }
        int[] result = new int[set_2.size()];
        int i = 0;
        for (int num : set_2){
            result[i] = num;
            i++;
        }
        return result;
    }

    public int[] intersection_1(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
