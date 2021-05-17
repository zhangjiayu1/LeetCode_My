package LCJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/17
 * Time: 21:37
 * Description:二叉树的前序遍历 根左右
 */
public class LC144PreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            //节点不为空
            while (node != null){
                //放入根节点的值
                list.add(node.val);
                //将此根节点放入栈中
                stack.push(node);
                //将结点指向左子树
                node = node.left;
            }
            //如果左子树节点为空，则指向当前栈中的根节点
            node = stack.pop();
            //指向右子树
            node = node.right;
        }
        return list;
    }
}
