package com.company;

public class Heap<T extends Comparable<T>>{
    private int size = 0;
    private int capacity = 5;
    private Object[] heap;

    public Heap(){
        heap = new Object[capacity];
    }

    public T getMax(){
        return get(0);
    }

    private T get(int index) {
        return (T) heap[index];
    }

    private int leftChildInd(int index){
        return 2*index;
    }

    private int rightChildInd(int index){
        return 2*index + 1;
    }

    boolean empty(){
        return size == 0;
    }

    int size(){
        return size;
    }

    void insert(T newHeap){
        if (size == capacity - 2) {
            capacity = (int) (2 * capacity);
            Object[] heap1 = new Object[capacity];
            for (int i = 0; i < size; i++) {
                heap1[i] = heap[i];
            }
            heap = heap1;
        }
        if(size == 0){
            heap[0] = newHeap;
            size++;
        } else {
            heap[size] = newHeap;
            size++;
            int currentIndex = size-1;
            while(true){
                if(currentIndex == 0) break;
                T current = get(currentIndex);
                int currentParentInd;
                if(currentIndex % 2 == 1){
                    currentParentInd = (currentIndex-1)/2;
                } else {
                    currentParentInd = (currentIndex - 2)/2;
                }
                T parent = get(currentParentInd);
                if(parent != null){
                    if(current.compareTo(parent) > 0){
                        Object temp = heap[currentIndex];
                        heap[currentIndex] = heap[currentParentInd];
                        heap[currentParentInd] = temp;

                        currentIndex = currentParentInd;
                    }
                    continue;
                }
                break;
            }
        }

    }

    public T extractMax() {
        T temp = getMax();
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        int currentIndex = 0;
        T current = get(currentIndex);
        while (current != null) {
            current = get(currentIndex);
            T left = get(leftChildInd(currentIndex));
            T right = get(rightChildInd(currentIndex));

            if (left != null) {
                if (right == null || left.compareTo(right) > 0)
                    if (current.compareTo(left) < 0) {
                        Object tempi = heap[currentIndex];
                        heap[currentIndex] = heap[leftChildInd(currentIndex)];
                        heap[leftChildInd(currentIndex)] = tempi;
                        currentIndex = leftChildInd(currentIndex);
                        continue;
                    }
            }
            if (right != null)
                if (current.compareTo(right) < 0) {
                    Object tempi = heap[currentIndex];
                    heap[currentIndex] = heap[rightChildInd(currentIndex)];
                    heap[rightChildInd(currentIndex)] = tempi;
                    currentIndex = rightChildInd(currentIndex);
                    continue;
                }
            break;
        }
        return temp;
    }

    public String printHeap(){
        String finalHeap = "";
        for(Object finHeap : heap){
            if(finHeap != null) finalHeap += finHeap.toString() + ";";
        }
        return finalHeap;
    }
}
