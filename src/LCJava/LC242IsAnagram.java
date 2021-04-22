package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/22
 * Time: 22:11
 * Description: 哈希表
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class LC242IsAnagram {

    public boolean isAnagram(String s, String t) {
        //长度不相等直接false
        if(s.length() != t.length()){
            return false;
        }
        //长度少可以用数组，多的话还是用哈希表比较快
        int[] Letter = new int[26];
        //建立一个长度为26的数组，出现一个字母，就在所在字母的位置加一
        for (int i = 0;i < s.length();i++){
            Letter[s.charAt(i) - 'a'] ++;
        }
        //同理，出现一次就减一，如果出现负数，证明在s中不存在
        for (int j = 0;j < t.length();j++){
            Letter[t.charAt(j) - 'a'] --;
            if(Letter[t.charAt(j) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
