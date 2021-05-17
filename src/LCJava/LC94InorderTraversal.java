package LCJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/17
 * Time: 21:27
 * Description: 二叉树的中序遍历
 */
public class LC94InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归解法
     * @param root 二叉树节点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }

    public void inOrder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);
    }

    /**
     * 迭代解法 利用栈
     * @param root 二叉树结点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null){
                //一直压栈，压倒没有左子树为止
                stack.push(node);
                node = node.left;
            }
            //左子树为空的时候，开始取值
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}









