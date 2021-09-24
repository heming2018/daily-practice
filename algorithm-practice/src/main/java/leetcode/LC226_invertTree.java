package leetcode;

/**
 * @author heming1
 * @date 2021/7/30 11:50 下午
 * @description 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转一棵二叉树
 */
public class LC226_invertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}