package LCJava;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/09
 * Time: 14:14
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class LC20IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if(length % 2 == 1){
            return false;
        }
        for (int i = 0;i < length;i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if (ch == '['){
                stack.push(']');
                //正如果是正确匹配的话，当下标到了右半部分括号时，每一个都可以与栈中的对应上，如果不对应，就是没有匹配好
            }else if(stack.isEmpty() || ch != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
