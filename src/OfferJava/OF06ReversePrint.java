package OfferJava;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/7 0007
 * Time: 17:56
 * Description:06. 从尾到头打印链表 easy
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 思路：方法一是借用外部存储空间栈，因为栈的特性是先进后出，这样最后放进去的就先出来，借此达到目的
 * 方法二是看了别人的题解得到的思路，用递归来做。终止判断条件是当head为null的时候，这时候往前回溯，把每一层的结点数值给加进去
 */
public class OF06ReversePrint {

    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int[] print = new int[stack.size()];
        for (int i = 0;i < print.length; i++){
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static int[] reversePrint1(ListNode head){
        reverse(head);
        int[] print = new int[arrayList.size()];
        for (int i = 0; i < print.length; i++) {
           print[i] = arrayList.get(i);
        }
        return print;
    }

    private static void reverse(ListNode head){
        if(head == null){
            return;
        }
        reverse(head.next);
        arrayList.add(head.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(1);
        int[] a = reversePrint(listNode);
        int[] b = reversePrint1(listNode);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
