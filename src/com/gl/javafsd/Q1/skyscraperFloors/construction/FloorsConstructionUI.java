package com.gl.javafsd.Q1.skyscraperFloors.construction;

import java.util.LinkedList;
import java.util.Scanner;

public class FloorsConstructionUI {

    //stores the distinct size of the floor that will be given to architect by factories on the ith day
    private LinkedList <Integer> floorSize;
    // stores total number of floors in the building
    private Integer totalFloors;
    // to accept input from the user
    Scanner input;

    public FloorsConstructionUI(){
        input= new Scanner(System.in);
    }

    // taking input of total number of floors from the user
    public void inputTotalFloors(){
        System.out.println("Enter the total number of floors in the building");
        totalFloors= input.nextInt();
    }

    // taking input of size of floor on each day from the user
    public void inputFloorSize() {
        floorSize = new LinkedList<Integer>();
        int day= 1;
        int currentFloorSize;
        while (day<=totalFloors){
            System.out.println("enter the floor size given on day :"+ day);
            currentFloorSize = input.nextInt();
            floorSize.add (currentFloorSize);
            day++;
        }
    }

    // this method calls another method to find order of construction of floors
    public void outputFloorConstruction(LinkedList<Integer> floorSize, Integer totalFloors){
        DailyFloorConstructionCalculator calculator= new DailyFloorConstructionCalculator(floorSize,totalFloors);
        calculator.calculateDailyFloors();
    }

    // this method calls above methods to get input, calculate floors constructed each day and prints it
    public void buildingUI (){
        inputTotalFloors();
        inputFloorSize();
        outputFloorConstruction(floorSize, totalFloors);
    }
}
