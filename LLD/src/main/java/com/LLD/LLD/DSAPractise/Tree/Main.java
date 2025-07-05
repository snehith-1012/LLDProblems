package com.LLD.LLD.DSAPractise.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.setHead(new TreeNode<>(2));

        List<TreeNode<Integer>> l = new ArrayList<>();
        for(int i=0;i<12;i++){
            l.add(new TreeNode<>(i+1));
        }

        tree.setHead(l.get(0));
        tree.getHead().setLeft(l.get(1));
        tree.getHead().setRight(l.get(2));
        tree.getHead().getLeft().setLeft(l.get(3));
        tree.getHead().getLeft().setRight(l.get(4));
        tree.getHead().getRight().setLeft(l.get(5));
        tree.getHead().getRight().setRight(l.get(6));

        tree.getHead().getLeft().getLeft().setLeft(l.get(7));
        tree.getHead().getLeft().getLeft().setRight(l.get(8));

        tree.getHead().getLeft().getRight().setLeft(l.get(9));
        tree.getHead().getLeft().getRight().setRight(l.get(10));

//        Main.traverseTreeInSpiralBfs(tree.getHead(),0);

//        List<List<Integer>> graph = new ArrayList<>(5);
//        for(int i=0;i<5;i++){
//            List<Integer> graphRow = new ArrayList<>(5);
//            for(int j=0;j<5;j++){
//                graphRow.add(0);
//            }
//            graph.add(graphRow);
//        }
//
//        for(int i=0;i<5;i++){
//            for(int j=0;j<5;j++){
//                System.out.println(graph.get(i).get(j));
//            }
//        }

        PriorityQueue<Map.Entry<Integer, TreeNode>> pq = new PriorityQueue<>((a, b) -> {
            return b.getKey() - a.getKey();
        });

        pq.add(new AbstractMap.SimpleEntry<>(1,null));
        pq.add(new AbstractMap.SimpleEntry<>(3,null));
        pq.add(new AbstractMap.SimpleEntry<>(2,null));

//        while(!pq.isEmpty()){
//            System.out.println(pq.poll().getKey());
//        }


//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        pq.add(1);
//        pq.add(3);
//        pq.add(2);



//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }
        System.out.println("dbcdd".compareTo("dda"));
    }

    public static void traverseTreeInSpiralBfs(TreeNode<Integer> head, int level){

        Deque<TreeNode<Integer>> q = new LinkedList<>();
        q.add(head);

        List<Integer> result = new ArrayList<>();

        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            if(!reverse) {
                for (int i = 0; i < size; i++) {
                    TreeNode<Integer> curr = q.getFirst();
                    q.removeFirst();
                    result.add(curr.getData());
                    System.out.print(curr.getData() + " ");
                    if (curr != null && curr.getLeft() != null) {
                        q.add(curr.getLeft());
                    }
                    if (curr != null && curr.getRight() != null) {
                        q.add(curr.getRight());
                    }
                }
                reverse = !reverse;
                System.out.println();
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode<Integer> curr = q.getLast();
                    q.removeLast();
                    result.add(curr.getData());
                    System.out.print(curr.getData() + " ");
                    if (curr != null && curr.getRight() != null) {
                        q.addFirst(curr.getRight());
                    }
                    if (curr != null && curr.getLeft() != null) {
                        q.addFirst(curr.getLeft());
                    }
                }
                reverse = !reverse;
                System.out.println();
            }
        }

        for(Integer i : result){
            System.out.print(i + " ");
        }

    }

}
