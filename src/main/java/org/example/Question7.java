package org.example;
//Consider we have one String as : "AADRAFDTYSS"
//Need to find out the occurrence of first non repeated charter from the given above String.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question7 {
    public static void main(String[] args) {
        String input="AADRAFDTYSS";
        char result=findFirstNonRepeatingChar(input);
        if(result!=' '){
            System.out.println(result+" is the first non-repeating character");
        }else{
            System.out.println("All charcters are repeated or empty/default");
        }

    }
    public static char findFirstNonRepeatingChar(String input) {

        //Creating a map to store character frequencies
        Map<Character, Integer> map=new HashMap<>();

        //Populating the map with character frequencies

        for(char c:input.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);

        }
        //Iterating through the string to find the first non-repeating character
        for(char c:input.toCharArray()){
            if(map.get(c)==1){
                return c; //found first repeating number
            }
        }
        return input.charAt(0);
    }


}
