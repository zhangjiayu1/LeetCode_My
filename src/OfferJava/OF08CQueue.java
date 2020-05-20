package OfferJava;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/20
 * Time: 15:38
 * Description:08 用两个栈实现队列 easy
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 思路：栈的特点是先进后出，队列的特点是先进先出。把第一个栈用来存数据，先存的就进到了栈底，这样appendTail()就解决了。从头删除操作的时候，因为栈先进后出，栈顶元素是最后插入的元素，
 * 栈底才是我们真正要删除的。这时候我们用pop()方法把栈中的元素全部取出，在push()到第二个栈中，根据栈先入后出的特性，第一个栈栈底的元素在第二个栈中就位于栈顶，此时将他删除，就实现了
 * 删除队列头部元素的操作
 *
 * 在评论区看到大佬说用LinkedList，Stack因为继承了Vector接口，Vector底层是一个Object[]数组，需要考虑空间扩容与移位的问题
 */
public class OF08CQueue {

    Stack<Integer> stack1,stack2;
    LinkedList<Integer> stack_1,stack_2;

    public OF08CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack_1 = new LinkedList<>();
        stack_2 = new LinkedList<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public void appendTail_1(int value){
        stack_1.add(value);
    }

    public int deleteHead(){
        if(stack1.empty() && stack2.empty()){
            return -1;
        }else if(!stack2.empty()){
            return stack2.pop();
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int deleteHead_1(){
        if(stack_1.isEmpty() && stack_2.isEmpty()){
            return -1;
        }else if(!stack_2.isEmpty()){
            return stack_2.pop();
        }
        while (!stack_1.isEmpty()){
            stack_2.push(stack_1.pop());
        }
        return stack_2.pop();
    }
}
