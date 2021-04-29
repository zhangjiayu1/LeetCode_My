package OfferJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/29
 * Time: 22:27
 * Description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class OF58_2ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder(s);
        reverse(str,0,n - 1);
        reverse(str,n,s.length() - 1);
        reverse(str,0,s.length() - 1);
        return new String(str);
    }

    public void reverse(StringBuilder str,int start,int end){
        while (start < end){
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start ++;
            end --;
        }
    }
}
