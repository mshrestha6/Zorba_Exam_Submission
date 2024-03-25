package model;

public class RailwayReservation {

private String passengerName;
private int passengerAge;
private String choosenSeat;
private String typeofReservation;
private double amountPaid;
private boolean isSeniorCitizen;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public String getChoosenSeat() {
        return choosenSeat;
    }

    public void setChoosenSeat(String choosenSeat) {
        this.choosenSeat = choosenSeat;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getTypeofReservation() {
        return typeofReservation;
    }

    public void setTypeofReservation(String typeofReservation) {
        this.typeofReservation = typeofReservation;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    @Override
    public String toString() {
        return "RailwayReservation{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", choosenSeat=" + choosenSeat +
                ", typeofReservation='" + typeofReservation + '\'' +
                ", amountPaid=" + amountPaid +
                ", isSeniorCitizen=" + isSeniorCitizen +
                '}';
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    public RailwayReservation(String passengerName) {
        this.passengerName = passengerName;
        this.passengerAge=passengerAge;
        this.choosenSeat=choosenSeat;
        this.typeofReservation=typeofReservation;
        this.isSeniorCitizen=isSeniorCitizen;
        this.amountPaid=amountPaid;
    }
    public void calculateAmountandSeiority(){
        if(passengerAge>60){
            isSeniorCitizen=true;
            choosenSeat="Aisle Seat";

        }else{
            isSeniorCitizen=false;
        }
        if(typeofReservation.equals("AC")){
            amountPaid=100.0;
        }else if(typeofReservation.equals("Non-AC")){
            amountPaid=60.0;
        }else {
            System.out.println("Invalid ticket...");
        }
    }
}
