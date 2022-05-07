package com.gl.javafsd.Q1.skyscraperFloors.construction;

import java.util.LinkedList;

public class DailyFloorConstructionCalculator {

    ///stores the distinct size of the floor that will be given to architect by factories on the ith day
    private LinkedList <Integer> floorSize;
    // stores total number of floors in the building
    private Integer totalFloors;
    // stores the floors' size in sorted order
    private LinkedList <Integer> sortedFloorSize;

    // constructor
    public DailyFloorConstructionCalculator(LinkedList<Integer> floorSize, Integer totalFloors) {
        this.floorSize = floorSize;
        this.totalFloors = totalFloors;
    }

    // method to find size of floors constructed on each day and prints it
    public void calculateDailyFloors(){

        // finds the sorted order of floor size
        FloorsSorting sorted= new FloorsSorting(floorSize);
        sortedFloorSize = sorted.sortingFloorsDescending();

        // stores size of floors that are already constructed but can not be assembled
        // as larger floor size is still not ready
        LinkedList <Integer> pastFloors= new LinkedList<Integer>();

        // index for the current maximum floor size
        int index_of_max=totalFloors-1;
        // current maximum floor size
        int current_max= sortedFloorSize.get(index_of_max);
        // stores the ith day
        int day=1;

        System.out.println("\nThe order of construction is as follows--");

        // loop runs for total number of floors as its same as total number of days
        while (day<=totalFloors){
            System.out.println("\nDay: "+day);

            // compares current max floor size with size of floor delivered on day stored in var "day"
            if (current_max== floorSize.get(day-1)){

                // prints max floor size if matched and
                // then searches for subsequent maximum floor sizes in the past list of floor sizes
                System.out.print (current_max+" ");
                if (index_of_max>0){
                    index_of_max--;
                    current_max= sortedFloorSize.get(index_of_max);
                    while (pastFloors.contains(current_max)){

                        // if found, prints the past floor sizes which can now be assembled
                        System.out.print (current_max+" ");
                        if (index_of_max>0){
                            index_of_max--;
                            current_max= sortedFloorSize.get(index_of_max);
                        }
                        else
                            break;
                    }
                }
            }
            else
            {
                // if current max floor size is not similar to present day's floor size then
                // it is stored in the linkedlist of past floors for assembly in coming days
                pastFloors.add(floorSize.get(day-1));
            }
            day++;
        }
    }
}
