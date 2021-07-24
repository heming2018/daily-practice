package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author heming1
 * @date 2021/7/24 7:01 下午
 * @description 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * TODO 这道题不太懂！！！
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC46_permute {

    public static void main(String[] args) {
        System.out.println(new LC46_permute().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int len = nums.length;
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Stack<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (len == path.size()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            used[i] = false;
            path.pop();
        }
    }

}