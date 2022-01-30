package com.tree;

import java.util.*;

public class TreeTraversal {
    TreeTraversal (){

    }

    public List<Integer> preorderTraversal(TreeNode root){
       List<Integer> l =new ArrayList<>();

       return preOrder(root,l);

    }

    private List<Integer> preOrder(TreeNode n, List<Integer> l) {

        if(n==null){
            return l;
        }
        l.add(n.val);
        preOrder(n.left,l);
        preOrder(n.right,l);
        return l;
    }

    private List<Integer> preOrderUsingStack(TreeNode n, List<Integer> l){


        if(n==null){
            return l;
        }
        LinkedList<TreeNode> s=new LinkedList<>();
        s.add(n);
        while(!s.isEmpty()){
            TreeNode t=s.pollLast();
            l.add(t.val);
            if(t.left!=null){
                s.add(t.left);
            }
            if(t.right!=null){
                s.add(t.right);
            }
        }


        return l;

    }
}
