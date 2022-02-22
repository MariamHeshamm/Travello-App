package com.example.travelo_app;

public class Wish {

   private int ID ;
   private int user_id ;
   private int hotel_id ;

    public Wish(int ID, int user_id, int hotel_id) {
        this.ID = ID;
        this.user_id = user_id;
        this.hotel_id = hotel_id;
    }

    public Wish(int user_id, int hotel_id) {

        this.user_id = user_id;
        this.hotel_id = hotel_id;
    }

    public int getID() {
        return ID;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }
}
