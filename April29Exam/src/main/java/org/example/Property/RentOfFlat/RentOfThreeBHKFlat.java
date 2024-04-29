package org.example.Property.RentOfFlat;

public class RentOfThreeBHKFlat {

    private boolean hasBalcony;

    private int noOfPerson;

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }
    public int calculateRentOfFlat(int noOfPerson) {
        int a =600*noOfPerson;
        return a;
    }
}
