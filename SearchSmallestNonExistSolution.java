package com.test;

import java.util.*;
import java.util.stream.Collectors;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class SearchSmallestNonExistSolution {
 public static int solution(int[] A) {
     // write your code in Java SE 8
     
	 Set<Integer> valueSet = Arrays.asList(A).stream()
		        .flatMapToInt(Arrays::stream)
		        .boxed()
		        .collect(Collectors.toSet());
     int smallest = 1;
     
     
     System.out.println(searchSmallestPositive(valueSet,smallest ));
     return smallest;
 }
 
 public static int searchSmallestPositive(Set<Integer> valueSet, int smallest){
     if(!valueSet.contains(smallest)){
         return smallest;
     }    
     
     return searchSmallestPositive(valueSet, ++smallest);
 }
 
 public static void main(String [] args) {
	 int [] test = new int [] {1, 3, 6, 4, 1, 2};
	 
	 System.out.println(solution(test));
 }
}
