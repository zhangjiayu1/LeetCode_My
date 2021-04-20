package LCJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/20
 * Time: 22:09
 * Description:链表
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class LC203RemoveElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        //递归边界
        if(head == null){
            return null;
        }
        //神人算法
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }


    public ListNode removeElements_1(ListNode head, int val) {
        //定义一个虚拟的头节点 问题的难点就在于如果需要删除的节点是头节点该怎么处理
        ListNode sentinel = new ListNode(0);
        //将虚拟头节点的next指向当前的头节点
        sentinel.next = head;
        //定义curr为当前节点，prev为前一个节点
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val){
                //前一个节点的next指向当前节点的next，把当前节点删除
                prev.next = curr.next;
            } else{
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}





























