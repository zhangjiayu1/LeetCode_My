package OfferJava;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/3/31 0031
 * Time: 18:15
 * Description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 * 思路：String.replace() 或者循环遍历字符串数组，构建一个StringBuilder对象来操作，以便节省空间。
 */
public class OF05ReplaceSpace {
    public static String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            if(String.valueOf(s.charAt(i)).equals(" ")){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy";
        System.out.println(replaceSpace1(s));
    }
}
