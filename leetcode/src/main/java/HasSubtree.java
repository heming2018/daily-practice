import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/12/3 00:02
 * @description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    private static final Logger logger = LoggerFactory.getLogger(HasSubtree.class);

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            res = doesTree1HaveTree2(root1, root2);
        }
        if (!res) {
            res = HasSubtree(root1.left, root2);
        }
        if (!res) {
            res = HasSubtree(root1.right, root2);
        }
        return res;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        // 四种情况
        // 1. 空，非空 false
        // 2. 空，空 true
        // 3. 非空，空 true
        // 4. 非空，非空 接着判断
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
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