package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heming1
 * @date 2021/7/20 11:46 上午
 * @description NC45 实现二叉树先序，中序和后序遍历
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class NC45_threeOrders {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> preList = new ArrayList<>();
        preOrder(root, preList);
        List<Integer> midList = new ArrayList<>();
        midOrder(root, midList);
        List<Integer> afterList = new ArrayList<>();
        afterOrder(root, afterList);

        int[][] res = new int[3][preList.size()];
        for (int i = 0; i < preList.size(); i++) {
            res[0][i] = preList.get(i);
        }
        for (int i = 0; i < preList.size(); i++) {
            res[1][i] = midList.get(i);
        }

        for (int i = 0; i < preList.size(); i++) {
            res[2][i] = afterList.get(i);
        }
        return res;
    }

    void preOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
        }
        if (node != null && node.left != null) {
            preOrder(node.left, list);
        }
        if (node != null && node.right != null) {
            preOrder(node.right, list);
        }
    }

    void midOrder(TreeNode node, List<Integer> list) {
        if (node != null && node.left != null) {
            midOrder(node.left, list);
        }
        if (node != null) {
            list.add(node.val);
        }
        if (node != null && node.right != null) {
            midOrder(node.right, list);
        }
    }


    void afterOrder(TreeNode node, List<Integer> list) {
        if (node != null && node.left != null) {
            afterOrder(node.left, list);
        }
        if (node != null && node.right != null) {
            afterOrder(node.right, list);
        }
        if (node != null) {
            list.add(node.val);
        }
    }



}