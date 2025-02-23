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
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, postorder,
                0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int[] postorder, int preStart,
                                          int preEnd, int postStart, int postEnd) {

        if (preEnd < preStart || postEnd < postStart) {
            return null;
        }
        TreeNode subRoot = new TreeNode(preorder[preStart], null, null);
        if (preStart == preEnd && postStart == postEnd) {
            return subRoot;
        }

        // recurse on left subtree
        int i = postStart, leftPreEnd = preEnd, leftPostEnd = postEnd;
        for (; i <= postEnd; i++) {
            if (preorder[preStart + 1] == postorder[i]) {
                leftPreEnd = preStart + (i - postStart + 1);
                leftPostEnd = i;
                break;
            }
        }
        subRoot.left = constructFromPrePost(preorder, postorder, preStart + 1, leftPreEnd, postStart, leftPostEnd);

        //recurse on right subtree
        subRoot.right = constructFromPrePost(preorder, postorder, leftPreEnd + 1, preEnd, leftPostEnd + 1, postEnd - 1);

        return subRoot;
    }
}
