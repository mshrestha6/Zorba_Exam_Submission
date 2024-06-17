package org.example;

//Write a program to check whether a number in prime number or not?
//Note: Prime number is a number that is greater than 1 and divided by 1 or itself only.
// In other words, prime numbers can't be divided by other numbers than itself or 1.
//For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the  number: ");
        int n = input.nextInt();

        if(isPrime(n)){
            System.out.println("Prime number");

        }else{
            System.out.println("Not Prime number");
        }


    }

    public static boolean isPrime(int n) {

        //Checking conditions
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
