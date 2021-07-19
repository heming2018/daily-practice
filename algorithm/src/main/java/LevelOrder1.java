import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 */
public class LevelOrder1 {

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return print(root, 0, list);

    }

    ArrayList<ArrayList<Integer>> print(TreeNode node, Integer level, ArrayList<ArrayList<Integer>> list) {
        if (list.size() <= level) {
            list.add(level, new ArrayList<>());
        }

        list.get(level).add(node.val);

        if (node.left != null) {
            print(node.left, level + 1, list);
        }
        if (node.right != null){
            print(node.right, level + 1, list);
        }
        return list;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key", "val");
        System.out.println(map);
    }
}