package com.example.travelo_app;

public class Coupon {
    int ID ;
    String number ;
    int value ;

    public Coupon(int ID, String number, int value) {
        this.ID = ID;
        this.number = number;
        this.value = value;
    }

    public Coupon( String number, int value) {
        this.number = number;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
