package com.example.travelo_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2="email";
    public static final String COL_3="password";
    public static final String COL_4="phone";
    public static final String COL_5="type";
    public static final String COL_6="name";

    public  static String gettID="";

    public static final String  HOTEL_TABLE = "Hotel";
    public static final String  H_ID = "ID";
    public static final String  H_location = "location";
    public static final String  H_name = "name";
    public static final String  H_ava_rooms = "ava_room";
    public static final String  H_price = "price";
    public static final String  H_persons_per_room = "persons_per_room";
    public static final String  H_city = "city";
    public static final String H_rate = "rate";
    public static final String H_main_IMG = "main_IMG";
    public static final String H_img_one ="img_one";
    public static final String H_img_two ="img_two";
    public static final String H_img_three ="img_three";
    public static final String H_wifi = "wifi";
    public static final String H_pet = "pet";
    public static final String H_pool = "pool" ;



    public static final String  Reservation_TABLE = "reservation";
    public static final String  R_ID = "ID";
    public static final String  R_num_of_reserved_rooms = "num_of_reserved_rooms";
    public static final String  R_checkin_date = "checkin_date";
    public static final String  R_checkout_date = "checkout_date";
    public static final String  R_user_ID = "user_ID";
    public static final String  R_hotel_ID = "hotel_ID";


    public static final String Wishlist_table = "wishlist";
    public static final String W_ID = "ID" ;
    public static final String W_user_id = "user_id" ;
    public static final String W_hotel_id = "hotel_id" ;


    public static final String coupon_table = "coupon";
    public static String C_ID = "ID";
    public static String C_number ="number" ;
    public static String C_value = "value" ;



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT,phone TEXT,type INTEGER DEFAULT 2,name TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Hotel ( ID INTEGER PRIMARY KEY AUTOINCREMENT ,   name TEXT,location TEXT, ava_room INTEGER , price INTEGER  ,city TEXT,persons_per_room INTEGER , rate INTEGER , main_IMG INTEGER , img_one TEXT , img_two TEXT , img_three TEXT , wifi INTEGER , pet INTEGER , pool INTEGER )");
        sqLiteDatabase.execSQL("CREATE TABLE reservation (ID INTEGER PRIMARY KEY AUTOINCREMENT , num_of_reserved_rooms INTEGER , checkin_date TEXT , checkout_date TEXT , user_ID INTEGER , hotel_ID INTEGER , FOREIGN KEY (user_ID) REFERENCES registeruser (ID) , FOREIGN KEY (hotel_ID) REFERENCES Hotel (ID) ) ");
        sqLiteDatabase.execSQL("CREATE TABLE wishlist (ID INTEGER PRIMARY KEY AUTOINCREMENT , user_id INTEGER , hotel_id INTEGER , FOREIGN KEY (user_id) REFERENCES registeruser (ID) , FOREIGN KEY (hotel_id) REFERENCES Hotel (ID))");
        sqLiteDatabase.execSQL("CREATE TABLE coupon ( ID INTEGER PRIMARY KEY AUTOINCREMENT , number TEXT , value INTEGER)");


        //add your value here in the same order of the table attributes
        sqLiteDatabase.execSQL("INSERT INTO Hotel (name , location , ava_room , price , persons_per_room , city , rate , main_IMG  , img_one , img_two , img_three , wifi , pet , pool) VALUES ( 'Kempinski Hotel Soma Bay' , 'geo:0,0?q=Kempinski Hotel Soma Bay, Safaga' , 4 , 2800 , 2 , 'Hurghada' , 4 , 2131099758 , 'https://cf.bstatic.com/images/hotel/max1024x768/184/184889024.jpg' ,'https://cf.bstatic.com/images/hotel/max1024x768/246/246814231.jpg' , 'https://cf.bstatic.com/images/hotel/max1024x768/246/246814097.jpg' , 0  , 1 ,1  ) ");
        sqLiteDatabase.execSQL("INSERT INTO Hotel (name , location , ava_room , price , persons_per_room , city , rate , main_IMG , img_one , img_two , img_three , wifi , pet , pool ) VALUES ( 'Sunrise Aqua Joy Resort' , 'geo:0,0?q=SUNRISE Aqua Joy Resort, Elmamsha, Hurghada' , 1 , 1500 , 3 , 'Hurghada' , 1 , 2131099775 , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' ,'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 1 , 1 , 1)");
        sqLiteDatabase.execSQL("INSERT INTO Hotel (name , location , ava_room , price , persons_per_room , city , rate , main_IMG  , img_one , img_two , img_three , wifi , pet , pool) VALUES ( 'Steigenberger Aqua Magic Red Sea' , 'geo:0,0?q=Steigenberger Aqua Magic Hotel, Youssef Affifi Rd, Hurghada, Red Sea Governorate' , 0 , 5000 , 1 , 'Hurghada' , 5 , 2131099774 , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' ,'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 0,1,1) ");
        sqLiteDatabase.execSQL("INSERT INTO Hotel (name , location , ava_room , price , persons_per_room , city , rate , main_IMG , img_one , img_two , img_three , wifi , pet , pool ) VALUES ( 'Continental Hotel Hurghada' , 'geo:0,0?q=Continental Hotel Hurghada, Mamsha, Hurghada' , 7 , 900 , 2 , 'Hurghada' , 2 , 2131099747 , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' ,'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 'https://u...content-available-to-author-only...a.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg' , 1 , 1 ,0 ) ");


        //coupon stuff
        sqLiteDatabase.execSQL("INSERT INTO coupon (number , value) VALUES ('xpsrrtl' , 10)");
        sqLiteDatabase.execSQL("INSERT INTO coupon (number , value) VALUES ('ddffdd' , 20)");
        sqLiteDatabase.execSQL("INSERT INTO coupon (number , value) VALUES ('llkkll' , 23)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ HOTEL_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Reservation_TABLE );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Wishlist_table );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + coupon_table);

        onCreate(sqLiteDatabase);
    }


    //registration needed functions

    public long addUser(String emaill,String pass,String phonee,String namee/*,String typee*/){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",emaill);
        cv.put("password",pass);
        cv.put("phone",phonee);
        cv.put("name",namee);
        // cv.put("type",1);
        long res=db.insert("registeruser",null,cv);
        db.close();
        return res;
    }
    public boolean Checkuser(String email,String pass){
        String [] colums={COL_1};
        SQLiteDatabase db=getWritableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String [] selectionArgs = {email,pass};
        Cursor c=db.query(TABLE_NAME,colums,selection,selectionArgs,null,null,null);
        int count=c.getCount();
        c.close();
        if(count>0){
            return true;
        }
        else
            return false;
    }

    public boolean checkEmail(String email){
        String [] columns={COL_1};
        SQLiteDatabase db=this.getWritableDatabase();
        String selection=COL_2 + " = ?";
        String [] selectionArgs={email};

        Cursor c=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=c.getCount();
        c.close();
        db.close();
        if (count>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkPhone(String phone){
        String [] columns={COL_1};
        SQLiteDatabase db=this.getWritableDatabase();
        String selection=COL_4 + " = ?";
        String [] selectionArgs={phone};

        Cursor c=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=c.getCount();
        c.close();
        db.close();
        if (count>0){
            return true;
        }
        else {
            return false;
        }
    }
    public void UpdatePassword(String emaill,String pass){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(COL_2,emaill);
        cv.put(COL_3,pass);
        db.update(TABLE_NAME,cv, COL_2+" = ?",new String[]{emaill});
        db.close();
    }
    public  Integer deleteData(String ID){
        SQLiteDatabase db=this.getReadableDatabase();
        return  db.delete(TABLE_NAME,COL_1+" = ?",new String[]{ID});
    }

    public String getID(String Email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, null, COL_2+" = ?", new String[]{Email}, null, null, null);
        if(cursor.getCount()<1) // Email Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        gettID= cursor.getString(cursor.getColumnIndex("ID"));
        return gettID;

    }

    // hotels functions
    public String getHotelID(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(HOTEL_TABLE, null,  H_name+" = ?", new String[]{name}, null, null, null);
        if(cursor.getCount()<1) // Email Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        gettID= cursor.getString(cursor.getColumnIndex("ID"));
        return  gettID;
    }
    public String getAvailableRoomNumber(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(HOTEL_TABLE, null,  H_name+" = ?", new String[]{name}, null, null, null);
        if(cursor.getCount()<1) // Email Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        gettID= cursor.getString(cursor.getColumnIndex("ava_room"));
        return  gettID;
    }

    public String getNameofHotel(int hotel_id)
    {
        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if (hotels.get(i).getID() == hotel_id)
                return hotels.get(i).getName();
        }
        return "";
    }
    public int getAvailablerooms2 (int hotelID){

        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if (hotels.get(i).getID()==hotelID)
                return hotels.get(i).getAva_room();
        }
        return 0;
    }
    public int getpersonsperrooms (int hotelID){

        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if (hotels.get(i).getID()==hotelID)
                return hotels.get(i).getPersons_per_room();
        }
        return 0;
    }
    public int getNRppmsPerHotel(int hotelID)
    {
        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if (hotels.get(i).getID()==hotelID)
                return hotels.get(i).getAva_room();
        }
        return 0;
    }

    public boolean checkAvailableRoomnumber (int hotelID,int roomnumberentered){

        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if ((hotels.get(i).getID()==hotelID)&&(roomnumberentered<=hotels.get(i).getAva_room()))
                return true;
        }
        return false;
    }

    public boolean checkAvailablePersonsPernumber (int hotelID,int personCount){

        ArrayList<Hotel> hotels = get_all_hotels();
        for(int i=0;i<hotels.size();i++) {
            if ((hotels.get(i).getID()==hotelID)&&(personCount<=hotels.get(i).getPersons_per_room()))
                return true;
        }
        return false;
    }
    public long addReservation(String UserID,String HotelID,String CheckIn,String Checkout,String nRooms/*,String typee*/){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("user_ID",UserID);
        cv.put("hotel_ID",HotelID);
        cv.put("checkin_date",CheckIn);
        cv.put("checkout_date",Checkout);
        cv.put("num_of_reserved_rooms",nRooms);
        // cv.put("type",1);
        long res=db.insert("registeruser",null,cv);
        db.close();
        return res;
    }

    Boolean check_ava_room (int hotelID , int number_of_rooms_needed ){
        Boolean flag = false ;
        ArrayList<Hotel> hotels = get_all_hotels();




        if (hotels.get(hotelID-1).getAva_room() >= number_of_rooms_needed)
            flag =true ;



        return  flag ;

    }


    // return an array list of all the hotels with the specific city

    public ArrayList <Hotel> get_all_hotels (){

        ArrayList <Hotel> Hotels = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Hotel " , null);

        if (c.moveToFirst()){
            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                String location = c.getString(2);
                int ava_room = c.getInt(3);
                int price = c.getInt(4);
                String city = c.getString(5);
                int persons_per_room = c.getInt(6);
                int rate = c.getInt(7);
                int main_IMG = c.getInt(8);
                String img_one = c.getString(9);
                String img_two = c.getString (10);
                String img_three = c.getString (11);
                int wifi = c.getInt (12);
                int pet = c.getInt(13) ;
                int pool = c.getInt(14) ;


                Hotels.add(new Hotel (id , name , location , ava_room , price , city , persons_per_room , rate , main_IMG , img_one , img_two , img_three , wifi , pet , pool)) ;

            } while (c.moveToNext() ) ;
            c.close();
        }


        return Hotels ;
    }



    public ArrayList <Hotel> get_hotels_in_city (String CITY){

        ArrayList <Hotel> Hotels = new ArrayList<>();

        String City_ = "'"+CITY+"'" ;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Hotel WHERE city =" + City_ , null);

        if (c.moveToFirst()){
            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                String location = c.getString(2);
                int ava_room = c.getInt(3);
                int price = c.getInt(4);
                String city = c.getString(5);
                int persons_per_room = c.getInt(6);
                int rate = c.getInt(7);
                int main_IMG = c.getInt(8);
                String img_one = c.getString(9);
                String img_two = c.getString (10);
                String img_three = c.getString (11);
                int wifi = c.getInt (12);
                int pet = c.getInt(13) ;
                int pool = c.getInt(14) ;


                Hotels.add(new Hotel (id , name , location , ava_room , price , city , persons_per_room , rate , main_IMG , img_one , img_two , img_three , wifi , pet , pool)) ;


            } while (c.moveToNext() ) ;
            c.close();
        }


        return Hotels ;
    }


    public Hotel get_hotel_data (int ID) {
        Hotel h  = get_all_hotels().get(ID-1);

        return h ;

    }

    public ArrayList<Hotel> get_liked_hotel ( int user_ID){


        ArrayList<Wish> all_wishes = get_wishes_for_selected_user(user_ID) ;


        ArrayList<Hotel> target_hotels = new ArrayList<>() ;

        for (int i = 0 ; i < all_wishes.size() ; i++){

            target_hotels.add( get_hotel_data( all_wishes.get(i).getHotel_id() )  );
        }


        return target_hotels ;
    }
    public boolean hotel_is_liked(int hotel_id,int user_ID)
    {
        boolean liked=false;
        ArrayList<Hotel> hotel=get_liked_hotel(user_ID);
        for(int i=0;i<hotel.size();i++)
        {
            if(hotel_id==hotel.get(i).getID())
            {
                liked=true;
                break;
            }
        }


        return liked;
    }

    ////////wish list needed functions


    //insert wish

    void add_wish (Wish w ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( W_user_id, w.getUser_id());
        values.put(W_hotel_id , w.getHotel_id());

        db.insert(Wishlist_table , null , values );

    }

    //remove a wish

    void delete_wish ( int USER_ID , int WISH_ID ){
        SQLiteDatabase db = getWritableDatabase();
        String args [] = {String.valueOf(USER_ID ) , String.valueOf(WISH_ID)};

        db.delete(Wishlist_table , "user_id=? and hotel_id = ?" , args );
    }

    //return the wishes for a selected user

    ArrayList<Wish> get_wishes_for_selected_user (int userID){
        ArrayList<Wish> wish = new ArrayList<>() ;

        String userid_ = "'"+userID + "'" ;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM wishlist WHERE user_id = " + userid_ , null);

        if (c.moveToFirst()){
            do {
                int res_id = c.getInt(0) ;
                int user_id = c.getInt(1) ;
                int hotel_id = c.getInt(2);

                wish.add(new Wish (res_id , user_id , hotel_id)) ;

            } while (c.moveToNext() ) ;
            c.close();
        }


        return wish ;
    }

// coupon stuff

    public boolean is_Coupon_exist (String number){

        boolean check = false ;

        ArrayList<Coupon> coupons = get_all_coupons();

        for (int i = 0 ; i < coupons.size() ; i++){

            if (coupons.get(i).number.equals(number)){
                check = true ;
                break;

            }

        }



        return check ;
    }
    public double Coupon_Value(String number)
    {
        ArrayList<Coupon> coupons = get_all_coupons();
        double num=0;
        for (int i = 0 ; i < coupons.size() ; i++) {

            if (coupons.get(i).number.equals(number)) {
                num=(coupons.get(i).getValue()/100.0);
            }
        }
        return num;
    }

    public ArrayList <Coupon> get_all_coupons (){

        ArrayList <Coupon> coupons = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM coupon " , null);

        if (c.moveToFirst()){
            do {
                int id = c.getInt(0);
                String number = c.getString(1);
                int value = c.getInt(2);


                coupons.add(new Coupon(id , number , value));

            } while (c.moveToNext() ) ;
            c.close();
        }


        return coupons ;
    }


}