package com.company;

public class Main {

    public static void main(String[] args) {
	    Heap<Integer> heap = new Heap<>();
        System.out.println(heap.empty());
	    for(int i = 0; i < 10; i++){
	        heap.insert(i);
        }
        System.out.println(heap.size());
        System.out.println(heap.printHeap());
        System.out.println(heap.extractMax());
        System.out.println(heap.printHeap());
    }
}
