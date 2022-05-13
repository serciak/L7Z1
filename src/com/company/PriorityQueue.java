package com.company;

import java.util.Comparator;

public class PriorityQueue<T> {

    private T[] array;
    private int size;
    private int defaultSize;
    private Comparator<T> comparator;

    public PriorityQueue(Comparator<T> comparator, int size) {
        this.comparator = comparator;
        defaultSize = size;
        this.size = -1;
        array = (T[]) new Object[size];
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int i1, int i2) {
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    private void swim(int index) {
        while (index > 0 && comparator.compare(array[index], array[parent(index)]) < 0) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private void sink(int index) {
        int maxIndex = index;
        int l = leftChild(index);

        if (l <= size && comparator.compare(array[l], array[maxIndex]) < 0) {
            maxIndex = l;
        }

        int r = rightChild(index);

        if (r <= size && comparator.compare(array[r], array[maxIndex]) < 0) {
            maxIndex = r;
        }

        if (index != maxIndex) {
            swap(index, maxIndex);
            sink(maxIndex);
        }
    }

    public void enqueue(T elem) {
        size++;
        array[size] = elem;
        swim(size);
    }

    public T dequeue() {
        T res = array[0];
        array[0] = array[size];
        --size;
        sink(0);
        return res;
    }

    public T first() {
        return array[0];
    }

    public boolean isEmpty() {
        return size != -1;
    }
}
