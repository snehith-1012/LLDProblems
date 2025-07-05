package com.LLD.LLD.DSAPractise.Tree;

public class Tree<T> {

    private TreeNode<T> head;

    public Tree(){
        this.head = null;
    }

    public TreeNode<T> getHead() {
        return head;
    }

    public void setHead(TreeNode<T> head) {
        this.head = head;
    }
}
