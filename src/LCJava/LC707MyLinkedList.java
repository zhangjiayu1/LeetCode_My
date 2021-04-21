package LCJava;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/04/21
 * Time: 20:49
 * Description:
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 *
 * 提示：
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class LC707MyLinkedList {

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

    class MyLinkedList{
        //虚拟头节点的值，其实记录的是链表的长度，一开始为0
        int length;
        ListNode head;
        public MyLinkedList() {
            length = 0;
            head = new ListNode(0);
        }

        /**
         * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
         * @param index 索引
         * @return 链表index位置的值
         */
        public int get(int index){
            if(index < 0 || index >= length){
                return -1;
            }
            ListNode cur = head;
            for (int i = 0;i <= index;i++){
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
         *  如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         * @param index 索引
         * @param value 插入的值
         */
        public void  addAtIndex(int index,int value){
            if(index > length){
                return;
            }
            if(index < 0){
                index = 0;
            }
            length++;
            ListNode cur = head;
            for (int i = 0;i < index;i++){
                cur = cur.next;
            }
            ListNode add = new ListNode(value);
            add.next = cur.next;
            cur.next = add;
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点。
         * @param index 要删除的索引
         */
        public void deleteAtIndex(int index){
            if(index >= length || index < 0){
                return;
            }
            length--;
            ListNode cur = head;
            for (int i = 0;i < index;i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        /**
         *在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
         * @param value 插入的value值
         */
        public void addAtHead(int value){
            addAtIndex(0,value);
        }

        /**
         *将值为 val 的节点追加到链表的最后一个元素。
         * @param value 插入的value值
         */
        public void addAtTail(int value){
            addAtIndex(length,value);
        }
    }
}



























