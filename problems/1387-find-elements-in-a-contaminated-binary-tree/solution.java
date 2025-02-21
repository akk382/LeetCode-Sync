/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

        private final Set<Integer> hashSet;

        public FindElements(TreeNode root) {
            this.hashSet = new HashSet<>();
            initializeNodes(root, 0);
        }

        private void initializeNodes(TreeNode root, int val) {
            if (root != null) {
                this.hashSet.add(val);
                initializeNodes(root.left, 2 * val + 1);
                initializeNodes(root.right, 2 * val + 2);
            }
        }

        public boolean find(int target) {
            return this.hashSet.contains(target);
        }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
