import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 */
public class LevelOrder {

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return list;
        }

        print(root, list, 0);
        return list;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key", "val");
        System.out.println(map);
    }

    void print(TreeNode node, ArrayList<ArrayList<Integer>> list, int n) {

        if (list.size() == n) {
            list.add(n, new ArrayList<Integer>());
        }

        ArrayList<Integer> curr = list.get(n);
        curr.add(node.val);

        if (node.left != null) {
            print(node.left, list, n + 1);
        }

        if (node.right != null) {
            print(node.right, list, n + 1);
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}