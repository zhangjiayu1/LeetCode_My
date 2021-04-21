package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/21
 * Time: 22:34
 * Description:双指针
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LC19RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //依旧是新建一个虚拟节点
        ListNode node = new ListNode(0,head);
        //三个指针都指向同一个节点
        ListNode start = node,end = node;
        //题目要求是倒数第n个节点，先让start往前走n个节点，当n步走完后，在让start跟end一起走
        while (n != 0){
            start = start.next;
            n--;
        }
        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        //当start走到最后的时候，end就走到了要删除的节点的前驱节点，这时把end的next指向next的next就好了
        end.next = end.next.next;
        //虚拟节点由于一直没有动，所以直接取next就是头节点
        node = node.next;
        return node;
    }

}















