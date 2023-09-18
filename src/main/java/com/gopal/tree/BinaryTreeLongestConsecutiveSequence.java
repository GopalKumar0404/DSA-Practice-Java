package com.gopal.tree;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {
//        val = x;
//        left = null;
//        right = null;
//    }
//}

public class BinaryTreeLongestConsecutiveSequence {
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        findLongestSequence(root, null, 1);
        return maxLen;
    }

    private void findLongestSequence(TreeNode node, TreeNode parent, int length) {
        if (node == null) return;

        if (parent != null && node.val == parent.val + 1) {
            length++;
        } else {
            length = 1;
        }

        maxLen = Math.max(maxLen, length);

        findLongestSequence(node.left, node, length);
        findLongestSequence(node.right, node, length);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        BinaryTreeLongestConsecutiveSequence solver = new BinaryTreeLongestConsecutiveSequence();
        int longestSequence = solver.longestConsecutive(root);
        System.out.println("Longest Consecutive Sequence: " + longestSequence);
    }
}

