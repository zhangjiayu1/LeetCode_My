package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/28
 * Time: 21:53
 * Description:
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 */
public class LC541ReverseStr {

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        //每隔k个翻转k个
        for (int i = 0;i < str.length;i += 2 * k){
            int left = i;
            int right = Math.min(i + k - 1,str.length - 1);
            while (left < right){
                char a = str[left];
                str[left] = str[right];
                str[right] = a;
                left ++;
                right --;
            }
        }
        return new String(str);
    }
}
