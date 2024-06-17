package org.example;

//Write a program to reverse an array of integer type, without using any available methods, need to write proper logic to reverse.
//
//Ex: Array - [12,32,45,69,67]
//After reverse - [67, 69, 45, 32, 12]

public class Question5 {
    public static void main(String[] args) {
        int[] array={10,89,65,98,65};
        System.out.println("Reversed array is: ");
        printReversedArray(array);

    }
    public static void printReversedArray(int[] array) {
        for(int i=array.length-1;i>=0;i--){
            System.out.print(array[i]+" ");
            if(i>0){
                System.out.print(", ");
            }
        }
    }
}
