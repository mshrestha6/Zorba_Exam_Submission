package org.example.Property;

import org.example.Property.RentOfFlat.RentOfOneBHKFlat;
import org.example.Property.RentOfFlat.RentOfThreeBHKFlat;
import org.example.Property.RentOfFlat.RentOfTwoBHKFlat;
import org.example.Property.SelfOwnedFlat.SelfOwnedOneBHKFlat;
import org.example.Property.SelfOwnedFlat.SelfOwnedThreeBHKFlat;
import org.example.Property.SelfOwnedFlat.SelfOwnedTwoBHKFlat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainExecution {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        RentOfOneBHKFlat oneBHKFlat=(RentOfOneBHKFlat)context.getBean("OneBHKFlat");
        System.out.println("Rent of One BHK Flat for 2 persons: "+oneBHKFlat.calculateRentOfFlat(2));

        RentOfTwoBHKFlat twoBHKFlat=(RentOfTwoBHKFlat)context.getBean("TwoBHKFlat");
        System.out.println("The rent of Two BHK flat for 4 persons: "+twoBHKFlat.calculaterentOfFlat(4));

        RentOfThreeBHKFlat threeBHKFlat=(RentOfThreeBHKFlat)context.getBean("ThreeBHKFlat");
        System.out.println("The rent of three BHK flat for 5 persons: "+threeBHKFlat.calculateRentOfFlat(5));

        SelfOwnedOneBHKFlat selfOwnedOneBHKFlat=(SelfOwnedOneBHKFlat) context.getBean("SelfOneBHKFlat");
        selfOwnedOneBHKFlat.setDimensions(10,10,5);
        System.out.println("Final price of Self Owned One BHK is: "+selfOwnedOneBHKFlat.finalPriceOfFlat());

        SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat=(SelfOwnedTwoBHKFlat) context.getBean("SelfTwoBHKFlat");
        selfOwnedTwoBHKFlat.setDimensions(4,6,7);
        System.out.println("Final price of Self Owned Two BHK is: "+selfOwnedTwoBHKFlat.finalPriceOfFlat());

        SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat=(SelfOwnedThreeBHKFlat) context.getBean("SelfThreeBHKFlat");
        selfOwnedThreeBHKFlat.setDimensions(5,20,10);
        System.out.println("Final price of Self Owned Three BHK is: "+selfOwnedThreeBHKFlat.finalPriceOfFlat());
    }
}
