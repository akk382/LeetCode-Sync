
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
    class NodeValueIndex {
        final Integer value;
        final int lastPos;
        public NodeValueIndex(Integer value, int lastPos) {
            this.value = value;
            this.lastPos = lastPos;
        }
    }

    // O(n)
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, TreeNode> levelToNode = new HashMap<>();

        int level = 0;
        NodeValueIndex currentElement = getCurrentElement(traversal, 0);
        levelToNode.put(0, new TreeNode(currentElement.value));
        int i = currentElement.lastPos;
        // To keep track of index for lvl[] and pos[] arrays
        for (; i < traversal.length(); i++) {
            if (traversal.charAt(i) == '-') {
                level += 1;
                continue;
            }

            currentElement = getCurrentElement(traversal, i);
            TreeNode child = new TreeNode(currentElement.value, null, null);
            TreeNode previouslyAddedNode = levelToNode.getOrDefault(level - 1, null);
            if (previouslyAddedNode.left == null) {
                previouslyAddedNode.left = child;
                levelToNode.put(level, child);
            } else {
                previouslyAddedNode.right = child;
                levelToNode.put(level, child);
            }
            level = 0;
            i = currentElement.lastPos - 1;  // This offsets the increment of i in this for loop.
        }

        return levelToNode.get(0);
    }

    private NodeValueIndex getCurrentElement(String traversal, int c) {
        int value = 0;
        while (c < traversal.length() && traversal.charAt(c) != '-') {
            value = value * 10 + (traversal.charAt(c++) - '0');
        }
        return new NodeValueIndex(value, c);
    }
}
