package com.gl.javafsd.Q1.skyscraperFloors.construction;

import java.util.Collections;
import java.util.LinkedList;

public class FloorsSorting {

    private LinkedList<Integer> floorSize;

    // constructor to get size of floors and creates a clone of this linkedlist
    public FloorsSorting(LinkedList<Integer> floorSize) {
        this.floorSize = (LinkedList<Integer>) floorSize.clone();
    }

    // this method uses inbuilt function to sort the cloned linkedlist and returns it
    public LinkedList<Integer> sortingFloorsDescending(){
        Collections.sort(floorSize);
        return floorSize;
    }
}
