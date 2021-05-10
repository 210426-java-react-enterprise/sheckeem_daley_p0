package com.revature.bank.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayList<I> {
    private int size = 0;
    private int defaultSize = 10;
    private I[] items;

    public GenericArrayList(int size){
        this.size = size;
        //this.items = new I[size]);
    }

    public GenericArrayList(Class<I> items, int size){
        this.size = size;
        this.items = (I[]) Array.newInstance(items, size);
    }

    public GenericArrayList() {}

    public int getSize() {
        return size;
    }

    public void add(I item) { //adds to end
        if (size >= defaultSize) {
            I[] resizedArray = Arrays.copyOf(items, (defaultSize += size));
            items = resizedArray;
        } else if (size == 0) {
            I[] resizedArray = Arrays.copyOf(items,1);
            items = resizedArray;
            items[size] = item;
        } else {
            items[size-1] = item;
        }
        ++size;
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
        //stub
        if (index >= size) {
            System.out.println("Array index is out of bounds! " +
                    "Returned item at largest index instead.");
            return items[size - 1];
        } else
            return items[index];
    }

    public I pop(int index) {
        I popped = get(index);
        remove(index);

        return popped;
    }
}