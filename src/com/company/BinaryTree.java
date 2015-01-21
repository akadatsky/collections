package com.company;

import java.util.AbstractCollection;
import java.util.Iterator;

public class BinaryTree<E extends Comparable<E>> extends AbstractCollection<E> {

    private int size = 0;
    private Node root;

    @Override
    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        size++;
        addLogic(e);
        return true;
    }

    private void addLogic(E e) {
        if (root == null) {
            root = new Node<E>(e);
        }
    }

    private class Node<E> {

        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private E element;

        public Node(E e) {
            element = e;
        }

        public Node(E element, Node<E> parent) {
            this.parent = parent;
            this.element = element;
        }
    }

    private class Itr<E> implements Iterator<E> {

        public Itr() {
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

    }

}
