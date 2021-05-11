package LCJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/09
 * Time: 14:31
 * Description:
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class LC1047RemoveDuplicates {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int length = S.length();
        for (int i = 0;i < length;i++){
            if(!stack.isEmpty()){
                //入栈之后，只要匹配到与当前栈顶相同的，直接出栈
                if(S.charAt(i) == stack.peek()){
                    stack.pop();
                    continue;
                }
            }
            stack.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}















