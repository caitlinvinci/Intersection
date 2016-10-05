/*
 * Intersect.java 
 * 
 * Caitlin Vinci
 * caitlinvinci@gmail.com
 *  
 * This program uses merge and its helper methods from 
 * SortCount.java. The method intersect was created to 
 * take two arrays and return a new array of each intersecting
 * integer. 
 * 
 */
import java.util.*;
public class Intersect {

    
    private static int MAX_VAL = 50;
    private static long moves;        // total number of moves
    private static long compares;     // total number of comparisons
    
    /*
     * compare - a wrapper that allows us to count comparisons.
     */
    private static boolean compare(boolean comparison) {
        compares++;
        return comparison;
    }
    
    /*
     * intersect takes two arrays, passes them to mergeSort, then
     * compares the two arrays using a merge technique to find instances
     * of intersection. 
     * An array of the intersecting integers is returned. 
     * 
     */
    public static int [] intersect(int [] arrA, int [] arrB) {

        int length = 0; 
        if (arrA.length >= arrB.length)
            length = arrB.length;
        else 
            length = arrA.length; 
        //make an array of the length of the shorter parameter
        int [] intersect = new int [length]; 
        
        mergeSort(arrA); 
        mergeSort(arrB); 
        
        System.out.println ("Sorted... " ); 
        printArray(arrA); 
        System.out.println();
        printArray(arrB); 
        
        System.out.println("Moves before intersect: " + moves); 
        int i = 0; //walks down the arrA array
        int j = 0; //walks down the arrB array
        int k = 0; //walks down the intersection array
        
        while (i < arrA.length && j < arrB.length) {

           
            if (compare(arrA[i] == arrB[j])) {
                
                if (k < intersect.length)
                    intersect[k] = arrA[i]; 
                    k++;
                    printArray(intersect);
                    i++; 
                    j++; 
            }
            
            else if (compare(arrA[i] < arrB[j])) {
                i++; 
                
            }
            else {
                j++; 
            }
            moves++;
        }
        System.out.println("Moves = " + moves); 
        
        return intersect; 
        
    }
    
    /* merge - helper method for mergesort */
    private static void merge(int[] arr, int[] tmp, 
                              int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into tmp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (compare(arr[i] < arr[j]))
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
            moves++;
        }
        
        while (i <= leftEnd) {
            tmp[k++] = arr[i++];
            moves++;
        }
        
        while (j <= rightEnd) {
            tmp[k++] = arr[j++];
            moves++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = tmp[i];
            moves++;
        }
    }
    
    /** mSort - recursive method for mergesort */
    private static void mSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end)
            return;
        
        int middle = (start + end)/2;
        mSort(arr, tmp, start, middle);
        mSort(arr, tmp, middle + 1, end);
        merge(arr, tmp, start, middle, middle + 1, end);
    }
    
    /** mergesort */
    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mSort(arr, tmp, 0, arr.length - 1);
    }
    
      /** 
     * randomArray - creates an array of randomly generated integers
     * with the specified number of elements
     */
    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (MAX_VAL + 1));
        }
        
        return arr;
    }
    
     /**
     * Prints the specified array in the following form:
     * { arr[0] arr[1] ... }
     */
    public static void printArray(int[] arr) {
        System.out.print("{ ");
        
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        
        System.out.println("}");
    }
    
    
    public static void main (String [] args) {
        int [] first = randomArray((int)((Math.random() * 50))) ;
        int [] second = randomArray((int)((Math.random() * 50)));
        moves = 0; 
        System.out.println("Moves should = zero: " + moves); 
        printArray(first); 
        System.out.println(); 
        printArray(second); 
        
        int [] merged = intersect(first, second); 
        System.out.println();
        System.out.println("Merged: "); 
        
        printArray(merged); 
        
    }
    
    
    
    
    
    
}