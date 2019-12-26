package LCJava;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2019/12/26
 * Time: 13:57
 * Description:856.括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 * 思路：由于算法快忘干净了，数据结构也不咋地，这里就用了最笨的法子，扫描。只有一个完整的()是提供分的，也就是一分，并列的括号是相加，
 *       套着的括号是分数乘以二，所以一开始默认为1分也就是一个完整的括号()的分数，扫描里面碰到(表示有套着的，就乘2，扫描到)就除以2，
 *       扫描到一整个()时就把分数加上
 */
public class LC856ScoreOfParentheses {
    public static int scoreOfParentheses(String s){
        int sum = 0;
        int bs = 1;
        for (int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                bs = bs << 1;
            }else {
                bs = bs >> 1;
                if(i != 0 && s.charAt(i-1) == '('){
                    sum += bs;
                }
            }
        }
        return sum;
    }

    /**
     * 官方答案运用的栈
     * 字符串 S 中的每一个位置都有一个“深度”，即该位置外侧嵌套的括号数目。例如，字符串 (()(.())) 中的 . 的深度为 2，因为它外侧嵌套了 2 层括号：(__(.__))。
     *
     * 我们用一个栈来维护当前所在的深度，以及每一层深度的得分。当我们遇到一个左括号 ( 时，我们将深度加一，并且新的深度的得分置为 0。当我们遇到一个右括号 ) 时，
     * 我们将当前深度的得分乘二并加到上一层的深度。这里有一种例外情况，如果遇到的是 ()，那么只将得分加一。
     *
     * 下面给出了字符串 (()(())) 每次对应的栈的情况：
     *
     * [0, 0] (
     * [0, 0, 0] ((
     * [0, 1] (()
     * [0, 1, 0] (()(
     * [0, 1, 0, 0] (()((
     * [0, 1, 1] (()(()
     * [0, 3] (()(())
     * [6] (()(()))
     */
    public static int scoreOfParentheses_1(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v,1));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println("scoreOfParentheses:"+scoreOfParentheses(s));
        System.out.println("scoreOfParentheses_1:"+scoreOfParentheses_1(s));
    }
}
