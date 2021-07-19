import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/7 4:40 下午
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {
    private static final Logger logger = LoggerFactory.getLogger(MaxDepth.class);

    public static void main(String[] args) {
        Node node = new Node();
        node.left = new Node();
        node.left.left = new Node();
        int deep = maxDepth(node);
        System.out.println(deep);

    }

    private static int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;

    }

    private static class Node {
        Node left;
        Node right;
    }

}