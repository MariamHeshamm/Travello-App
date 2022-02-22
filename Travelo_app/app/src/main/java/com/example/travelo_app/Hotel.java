package com.example.travelo_app;

public class Hotel  {

    private int ID ;
    private String name ;
    private String location ;
    private int ava_room ;
    private int price ;
    private String city ;
    private int persons_per_room ;
    private int rate ;
    private int main_IMG ;
    private String img_one ;
    private String img_two ;
    private String img_three ;
    private int wifi ;
    private int pet ;
    private int pool ;


    public Hotel(int ID, String name, String location, int ava_room, int price, String city, int persons_per_room, int rate, int main_IMG, String img_one, String img_two, String img_three, int wifi, int pet, int pool) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.ava_room = ava_room;
        this.price = price;
        this.city = city;
        this.persons_per_room = persons_per_room;
        this.rate = rate;
        this.main_IMG = main_IMG;
        this.img_one = img_one;
        this.img_two = img_two;
        this.img_three = img_three;
        this.wifi = wifi;
        this.pet = pet;
        this.pool = pool;
    }

    public Hotel( String name, String location, int ava_room, int price, String city, int persons_per_room, int rate, int main_IMG, String img_one, String img_two, String img_three, int wifi, int pet, int pool) {

        this.name = name;
        this.location = location;
        this.ava_room = ava_room;
        this.price = price;
        this.city = city;
        this.persons_per_room = persons_per_room;
        this.rate = rate;
        this.main_IMG = main_IMG;
        this.img_one = img_one;
        this.img_two = img_two;
        this.img_three = img_three;
        this.wifi = wifi;
        this.pet = pet;
        this.pool = pool;
    }

    public Hotel (Hotel h ){

        this.ID = h.getID();
        this.name = h.getName();
        this.location = h.getLocation();
        this.ava_room = h.getAva_room();
        this.price = h.getPrice();
        this.city = h.getCity();
        this.persons_per_room = h.getPersons_per_room();
        this.rate = h.getRate();
        this.main_IMG = h.getMain_IMG();
        this.img_one = h.img_one  ;
        this.img_two = h.img_one ;
        this.img_three = h.img_three ;
        this.wifi = h.wifi;
        this.pool = h.pool;
        this.pet = h.pet;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAva_room() {
        return ava_room;
    }

    public void setAva_room(int ava_room) {
        this.ava_room = ava_room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPersons_per_room() {
        return persons_per_room;
    }

    public void setPersons_per_room(int persons_per_room) {
        this.persons_per_room = persons_per_room;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMain_IMG() {
        return main_IMG;
    }

    public void setMain_IMG(int main_IMG) {
        this.main_IMG = main_IMG;
    }

    public String getImg_one() {
        return img_one;
    }

    public void setImg_one(String img_one) {
        this.img_one = img_one;
    }

    public String getImg_two() {
        return img_two;
    }

    public void setImg_two(String img_two) {
        this.img_two = img_two;
    }

    public String getImg_three() {
        return img_three;
    }

    public void setImg_three(String img_three) {
        this.img_three = img_three;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getPet() {
        return pet;
    }

    public void setPet(int pet) {
        this.pet = pet;
    }

    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }
}