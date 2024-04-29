package org.example.Property.SelfOwnedFlat;

public class SelfOwnedTwoBHKFlat {
    private float length;
    private float breadth;
    private float height;

    public void setDimensions(float length, float breadth, float height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBreadth() {
        return breadth;
    }

    public void setBreadth(float breadth) {
        this.breadth = breadth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float calculatePlot(){
        return length * breadth * height;
    }
    public float finalPriceOfFlat(){
        return 30000*calculatePlot();
    }
}
