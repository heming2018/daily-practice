import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/12/10 14:46
 * @description 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {
    private static final Logger logger = LoggerFactory.getLogger(Mirror.class);


    /**
     * 二叉树的镜像定义：源二叉树
     * 8
     * /  \
     * 6   10
     * / \  / \
     * 5  7 9 11
     * 镜像二叉树
     * 8
     * /  \
     * 10   6
     * / \  / \
     * 11 9 7  5
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    private void mirrorSingle(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirrorSingle(root.left);
        }
        if (root.right != null) {
            mirrorSingle(root.right);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}