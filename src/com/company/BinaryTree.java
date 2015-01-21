package com.company;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> extends AbstractCollection<E> {

    private int size = 0;
    private Node root;

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        return addLogic(e);
    }

    private boolean addLogic(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return true;
        }
        Node tmp = root;
        while (true) {
            int compareResult = e.compareTo(tmp.element);

            if (compareResult < 0) {
                if (tmp.left == null) {
                    tmp.left = new Node(e, tmp);
                    size++;
                    return true;
                } else {
                    tmp = tmp.left;
                    continue;
                }
            }

            if (compareResult > 0) {
                if (tmp.right == null) {
                    tmp.right = new Node(e, tmp);
                    size++;
                    return true;
                } else {
                    tmp = tmp.right;
                    continue;
                }
            }

            if (compareResult == 0) {
                return false;
            }

        }
    }

    private class Node {

        private Node parent;
        private Node left;
        private Node right;
        private E element;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node parent) {
            this.parent = parent;
            this.element = element;
        }
    }

    private class Itr implements Iterator<E> {

        private Queue<Node> queue = new LinkedList<Node>();

        public Itr() {
            iterateTree(root);
        }

        private void iterateTree(Node node) {
            if (node == null) {
                return;
            }
            iterateTree(node.left);
            queue.add(node);
            iterateTree(node.right);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            return queue.poll().element;
        }

    }

}
