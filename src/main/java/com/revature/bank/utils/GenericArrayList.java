package com.revature.bank.utils;

import java.lang.reflect.Array;

public class GenericArrayList<I> {
    private int size = 0;
    private int defaultSize = 10;
    private I[] items = null;

    public GenericArrayList(int size){
        this.size = size;
        items = (I[])new Object[size];
        //this.items = new I[size]);
    }

    public GenericArrayList(Class<I> items, int size){
        this.size = size;
        this.items = (I[])new Object[size];
    }

    public GenericArrayList() {}

    public int getSize() {
        return size;
    }

    public void add(I item) { //adds to end
        if (size >= defaultSize) {
            //I[] resizedArray = Arrays.copyOf(items, (defaultSize += size));
            I[] resizedArray = (I[]) new Object[items.length + 1];
            for (int i = 0; i < items.length; i++) resizedArray[i] = items[i];
            items = resizedArray;
        } else if (size == 0) {
            Array.set(items,0,item);
            //I[] resizedArray = Arrays.copyOf(items, 1);
            I[] resizedArray = (I[]) new Object[items.length + 1];
            for (int i = 0; i < items.length; i++) resizedArray[i] = items[i];
            items = resizedArray;
            items[size] = item;
        } else {
            //I[] resizedArray = Arrays.copyOf(items, size);
            I[] resizedArray = (I[]) new Object[items.length + 1];
            for (int i = 0; i < items.length; i++) resizedArray[i] = items[i];
            items = resizedArray;
            items[size-1] = item;
        }
        size++;
    }

    public void add(I item, int index) { //inserts at index
        //stub
    }

    public void remove(int index) { //removes item at --index
        System.out.println("Array size before: " + size);
        if (index < size) {
            for (int i = 0; i < size; i++){
                if (i < index)
                    items[i] = items[i];
                else if (i > index)
                    items[i - 1] = items[i];
            }
        }
        --size;
        System.out.println("Array size after: " + size);
    }

    //public I[] toArray() {}

    public I get(int index) {
        /*
        if (index >= size) {
            System.out.println("Array index is out of bounds! " +
                    "Returned item at largest index instead.");
            return items[size - 1];
        } else
            return items[index];
        */
        return (I) Array.get(items, index);
    }
    public I[] trim() {
        for (int i = 0; i < size - 1; i++) {
            if (i >= size - 2) break;
            else if (items[i + 1] == null){
                size--;
            }
        }


        items = (I[]) Array.get(items, 0);
        return items;
    }
    public I pop(int index) {
        I popped = get(index);
        remove(index);

        return popped;
    }
}