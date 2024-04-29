package org.example.Property.RentOfFlat;

public class RentOfOneBHKFlat {
    private int noOfPerson;

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }
    public int calculateRentOfFlat(int noOfPerson) {
        int x=250*noOfPerson;
        return 250 * x;
    }
}
