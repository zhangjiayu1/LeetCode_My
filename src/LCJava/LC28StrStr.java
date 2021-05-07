package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/07
 * Time: 23:24
 * Description: KMP
 *
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * KMP算法核心  最长相等前后缀数组 next数组
 * p[l] != p[r] l==0 next[r] = 0; l != 0  l = next[l - 1]
 * p[l] = p[r] next[r] = l + 1; l++;r++;
 */
public class LC28StrStr {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int h = haystack.length();
        int n = needle.length();
        char[] ss = haystack.toCharArray();
        char[] pp = needle.toCharArray();
        int[] next = new int[n];
        for(int left = 0,right = 1;right < n; right++){
            while(left > 0 && pp[left] != pp[right]){
                left = next[left - 1];
            }
            if(pp[left] == pp[right]){
                //这一步在这可以忽略，因为最后进行了赋值，这里再赋值就重复了
                //next[right] = left + 1;
                left ++;
            }
            //if(left == 0 && pp[left] != pp[right]){
            next[right] = left;
            //}
        }
        for(int up = 0,down = 0;up < h;up++){
            while(down > 0 && ss[up] != pp[down]){
                down = next[down - 1];
            }
            if(ss[up] == pp[down]){
                down ++;
            }
            if(down == n){
                return up - n + 1;
            }
        }
        return -1;

    }
}
