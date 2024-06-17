package org.example;
// Write a program to search a minimum and maximum values from a given int array

public class Question2 {
    public static void main(String[] args) {
        int[] num={10,20,30,40,50,60,70,80,90};
        int min=num[0];
        int max=num[0];

        for(int i=1;i<num.length;i++){
            if(num[i]<min){
                min=num[i];
            }
            if(num[i]>max){
                max=num[i];
            }
        }
        System.out.println("Minimum number is: "+min);
        System.out.println("Maximum number is: "+max);
    }
}
