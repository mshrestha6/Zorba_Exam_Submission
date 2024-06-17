package org.example;
//Write a program to check whether two array are having exactly same elements

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        int[] a={10,20,30,40,50,60,70,80,90};
        int[] b={10,20,30,40,50,60,76,80};

        //Checks if they have same elements in both arrays
        boolean result= Arrays.equals(a,b);
        if(result) {
            System.out.println("Two arrays have same elements");
        }else{
                System.out.println("Two arrays have different elements");
            }
        }
    }

