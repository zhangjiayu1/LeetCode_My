package LCJava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/24
 * Time: 13:38
 * Description:
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class LC454FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //A[i] + B[j] + C[k] + D[l] = 0 ==> A[i] + B[j] = -(C[k] + D[l])
        Map<Integer,Integer> map1 = new HashMap<>();
        int result = 0;
        for (int i : nums1){
            for (int j : nums2){
                //先算一下数组ab中的和，放到map中，和作为key，value为出现的次数
                map1.put((i + j),map1.getOrDefault((i + j),0) + 1);
//                if (map1.containsKey(i + j)){
//                    int count = map1.get((i + j));
//                    map1.put((i + j),count + 1);
//                }else {
//                    map1.put((i + j),1);
//                }
            }
        }
        for (int k : nums3){
            for (int l : nums4){
                //同理 在数组cd的和中找ab和的负数
                if (map1.containsKey(-(k + l))){
                    result += map1.get(-(k + l));
                }
            }
        }
        return result;
    }
}
