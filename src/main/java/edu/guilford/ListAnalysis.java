package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListAnalysis 
{
    public static void main( String[] args )
    {
        //Constant for the number of elements in the list  = 1000
        final int MAX = 1000;
        //Declare and Instantiate an ArrayList of Animal objects
        ArrayList<Animal> animalArray = new ArrayList<Animal>();
        //Declare and Instantiate a LinkedList of Animal objects
        LinkedList<Animal> animalLinked = new LinkedList<Animal>();

        //Add the 1000 Animal objects to the ArrayList and LinkedList
        for (int i = 0; i < MAX; i++) {
            animalArray.add(new Animal());
            animalLinked.add(new Animal());
        }

        //********time how long it takes to add 1000 elements to both lists********
        //ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            animalArray.add(new Animal());
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds");

        //LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            animalLinked.add(new Animal());
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds\n");

        //********time how long it takes to sort both lists********
        //******Using Collection.sort*******
        //ArrayList
        startTime = System.nanoTime();
        Collections.sort(animalArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList sort time: " + 
        String.format("%.2f", duration / 1.e6) + " milliseconds");

        //LinkedList
        startTime = System.nanoTime();
        Collections.sort(animalLinked);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList sort time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds\n");

        //*******time how long it takes to shuffle both lists********
        //ArrayList
        startTime = System.nanoTime();
        Collections.shuffle(animalArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList shuffle time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds");

        //LinkedList
        startTime = System.nanoTime();
        Collections.shuffle(animalLinked);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList shuffle time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds\n");

        //********time 1,000,000 random gets from both lists**********
        //ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            animalArray.get((int)(Math.random() * MAX));
            //This could also work
            //int index = (int)(Math.random() * MAX);
            //Animal a = animalArray.get(index);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList random get time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds");

        //LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            animalLinked.get((int)(Math.random() * MAX));
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList random get time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds\n");

        //*********time both lists to get each element sequentially*********
        //ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            animalArray.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList sequential get time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds");

        //LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            animalLinked.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList sequential get time: " +
        String.format("%.2f", duration / 1.e6) + " milliseconds");

    }
}
