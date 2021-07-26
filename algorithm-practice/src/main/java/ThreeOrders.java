import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heming1
 * @date 2021/6/18 4:21 下午
 * 
 */
public class ThreeOrders {
    private static final Logger logger = LoggerFactory.getLogger(ThreeOrders.class);

    public int[][] threeOrders(TreeNode root) {
        // write code here

        List<List<TreeNode>> list = new ArrayList<>();
        list.add(preOrder(root, null));
        list.add(inOrder(root, null));
        list.add(postOrder(root, null));

        int[][] arr = new int[3][list.get(0).size()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                arr[i][j] = list.get(i).get(j).val;
            }
        }
        return arr;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    List<TreeNode> preOrder(TreeNode treeNode, List<TreeNode> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (treeNode != null) {
            list.add(treeNode);
            preOrder(treeNode.left, list);
            preOrder(treeNode.right, list);
        }
        return list;
    }

    List<TreeNode> inOrder(TreeNode treeNode, List<TreeNode> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (treeNode != null) {
            inOrder(treeNode.left, list);
            list.add(treeNode);
            inOrder(treeNode.right, list);
        }
        return list;
    }

    List<TreeNode> postOrder(TreeNode treeNode, List<TreeNode> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (treeNode != null) {
            postOrder(treeNode.left, list);
            postOrder(treeNode.right, list);
            list.add(treeNode);
        }
        return list;
    }

}