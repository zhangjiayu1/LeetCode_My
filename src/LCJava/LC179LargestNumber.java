package LCJava;

import java.util.Arrays;
import java.util.Comparator;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/12/05
 * \* Time: 15:34
 * \* Description:179、 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 * \*               示例 1:
 *              输入: [10,2]
 *                  输出: 210
 *                  示例 2:
 *              输入: [3,30,34,5,9]
 *              输出: 9534330
 *    思路：问题关键就在排序上。利用compareTo函数对拼接后的字符串进行一下排序，按照字典序
 *    时间：O(nlogn) 空间：O(n)
 */
public class LC179LargestNumber {

    public static String LargestNumber(int[] nums){

        //看题解有牛人用lambda表达式与stream解决的，很简洁，思路其实是一致的
//        StringBuilder res = new StringBuilder();
//        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
//        return res.charAt(0) == '0' ? "0" : res.toString();

        //自己最初的想法
        String zero = "0";
        String[] numStr = new String[nums.length];
        for (int i = 0;i < numStr.length;i++){
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        if(zero.equals(numStr[0])){
            return "0";
        }
        String str = new String();
        for (String i : numStr){
            str += i;
        }
        return str;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,30,34,5,9};
        System.out.println(LargestNumber(num));
    }
}
