package com.tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 */
public class PathMaxSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){

        }
        TreeNode(int val){
            this.val=val;

        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }


    }

    static int max_sum=Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        max_sum(root);
        return max_sum;

    }
    public static void main(String args[]){
        TreeNode node=new TreeNode();
        node.val=1;
        node.left=new TreeNode(2,new TreeNode(4),new TreeNode(5));
        node.right=new TreeNode(20,null,null);
        System.out.println(maxPathSum(node));
    }

    public static int max_sum(TreeNode node){
        if(node==null){
            return 0;
        }

        // get left max and right max
        int leftM=Math.max(max_sum(node.left),0);
        int rightM=Math.max(max_sum(node.right),0);
        int subtreesum=node.val+leftM+rightM;

        max_sum=Math.max(max_sum,subtreesum);

        return node.val+Math.max(leftM,rightM);
    }
}
