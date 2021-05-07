package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/07
 * Time: 23:29
 * Description:KMP
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class LC459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if(length == 0){
            return false;
        }
        char[] pattern = s.toCharArray();
        int[] next = new int[length];
        for(int left = 0,right = 1;right < length;right++){
            while(left > 0 && pattern[left] != pattern[right]){
                left = next[left - 1];
            }
            if(pattern[left] == pattern[right]){
                //这一步在这可以忽略，因为最后进行了赋值，这里再赋值就重复了
                //next[right] = left + 1;
                left ++;
            }
            //有前两步的判断，这里剩下的就是left等于0的情况了，所以可以直接赋值left
            next[right] = left;
        }
        if(next[length - 1] != 0 && length % (length - next[length - 1]) == 0){
            return true;
        }
        return false;
    }

}
