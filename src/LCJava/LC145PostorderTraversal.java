package LCJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2021/05/17
 * Time: 22:05
 * Description:二叉树的后序遍历 左右根
 */
public class LC145PostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null){
            //节点不为空
            while (node != null){
                //将此根节点放入栈中
                stack.push(node);
                //将结点指向左子树
                node = node.left;
            }
            //当没有左子树的时候，就把栈顶的节点取出，去找他的右子树
            node = stack.pop();
            // 判断当前栈顶元素右子是否访问过或无右子
            // 即可以直接计入结果的节点
            if(node.right == null || pre == node.right){
                list.add(node.val);
                pre = node;
                node = null;
            }else{
                //这是右子树不为空的时候，就把当前这个节点压入栈，然后去看他的右子树的左右子树情况
                stack.push(node);
                node = node.right;
            }
        }
        return list;
    }

}
