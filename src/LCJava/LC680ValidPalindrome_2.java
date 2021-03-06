package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/01/08
 * Time: 16:47
 * Description:680. 验证回文字符串 Ⅱ easy
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 思路：分别从字符串两端进行遍历，当两端字符不一样的时候，分别对i+1 - j与i - j-1在进行对比，这两个只要有一个是回文字符串，那就可以
 *       将两个的结果或一下，即可
 */
public class LC680ValidPalindrome_2 {

    public static boolean validPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return isValid(s,i + 1,j) || isValid(s,i,j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isValid(String s,int i,int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}
