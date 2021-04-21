package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/21
 * Time: 21:54
 * Description:
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class LC206ReverseList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            //记录一下当前节点的下一个节点
            ListNode listNode = cur.next;
            //将当前节点的下一个指向前面一个节点
            cur.next = pre;
            //cur与pre都往后走一步
            pre = cur;
            cur = listNode;
        }
        return pre;
    }

    /**
     * 递归解法
     * @param head head
     * @return ListNode
     */
    public ListNode reverseList_1(ListNode head){
        //递归终止条件，当前节点为空或者next为空
        if(head == null || head.next == null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //假如说链表示1 → 2 → 3 → 4 → 5，那么从最后一层返回的cur就是5，当前层的head就是4
        //head的next是5 要想反转就是让5的next等于4，所以就是head.next.next = head 即5.next = 4
        head.next.next = head;
        //此时5的next指向了4，那4的next就不能指向5了，否则就成了循环链表，所以置为空，然后再靠上一层的递归来改变next值
        head.next = null;
        return cur;
    }
}
