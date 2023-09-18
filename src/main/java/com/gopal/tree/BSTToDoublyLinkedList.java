package com.gopal.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class DoublyListNode {
    int val;
    DoublyListNode prev, next;
    DoublyListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}

public class BSTToDoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;

    public DoublyListNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        
        inOrderTraversal(root);
        
        head.prev = tail;
        tail.next = head;
        
        return head;
    }
    
    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        
        inOrderTraversal(node.left);
        
        DoublyListNode newNode = new DoublyListNode(node.val);
        
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        
        tail = newNode;
        
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BSTToDoublyLinkedList converter = new BSTToDoublyLinkedList();
        DoublyListNode head = converter.treeToDoublyList(root);
        
        // You can traverse the doubly linked list to verify the result
    }
}
