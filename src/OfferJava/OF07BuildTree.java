package OfferJava;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/19
 * Time: 16:38
 * Description:07.重建二叉树 medium
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 思路：先序遍历是根左右，中序遍历是左根右
 */
public class OF07BuildTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preOrder,int[] inOrder){
        HashMap<Integer,Integer> map = new HashMap<>();
        //把中序遍历的数组数值以及位置存到map中
        for (int i = 0;i < preOrder.length; i++){
            map.put(inOrder[i],i);
        }
        TreeNode tree = reBuild(preOrder,0,preOrder.length - 1,inOrder,0,inOrder.length - 1,map);
        return tree;
    }

    public static TreeNode reBuild(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        //终止条件，相等的话是自身，大于的话就表示已经走完了
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        //先序遍历的第一个节点就是根节点
        int rootVal = preOrder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //获取中序遍历中根节点的位置，根节点之前的是左子树，右边的是右子树
        int rootIndex = map.get(rootVal);
        //左子树的左边界就是左子树前序遍历的第一个，也就是preStart + 1(左边界)，右边界: rootIndex - inStart得出左子树节点的个数，preStart加上这个数值即为右边界的位置
        //在中序遍历中左子树的左边界是开始，右边界是总的根节点的前一个位置
        root.left = reBuild(preOrder,preStart + 1,preStart + rootIndex - inStart,inOrder,inStart,rootIndex - 1,map);
        //右子树的左边界在先序遍历中是左边界的结束位置 + 1，右边界一直到最后
        //中序遍历中 右子树的左边界是根节点位置 + 1，右边界为最后
        root.right = reBuild(preOrder,preStart + rootIndex - inStart + 1,preEnd,inOrder,rootIndex + 1,inEnd,map);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
        buildTree(preOrder,inOrder);
    }
}
