package org.example.Property.RentOfFlat;

public class RentOfTwoBHKFlat {
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
    public int calculaterentOfFlat(int noOfPerson) {
        int b=400*noOfPerson;
        return b;
    }
}
