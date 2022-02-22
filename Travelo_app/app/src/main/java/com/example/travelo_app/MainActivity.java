package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputLayout etchecin,etcheckout,etrooms,etpersons,etdest,etcuopon;
    TextView tvfees,tvbook;
    DatabaseHelper db;
    Button btnreserve;
    int iday,imonth,iyear;
    int oday,omonth,oyear;
    Date dt1,dt2;
    int hotel_ID;
    int user_ID;
    long diffDays=0;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String checkindate,chectoutdate,npersons,nrooms,dest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etrooms=findViewById(R.id.et_roomnum);
        etpersons=findViewById(R.id.et_peoplenum);
        etdest=findViewById(R.id.et_dest);
        tvfees=findViewById(R.id.tv_fees);
        btnreserve=findViewById(R.id.btn_Reserve);
        etchecin=findViewById(R.id.et_Checkin);
        etcheckout=findViewById(R.id.et_Checkout);
        etcuopon=findViewById(R.id.et_Cupon);
        etchecin.setOnClickListener(this);
        etcheckout.setOnClickListener(this);
        btnreserve.setOnClickListener(this);
        db=new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        user_ID = bundle.getInt("ID", -1);
        hotel_ID=bundle.getInt("Hotel_ID",-1);
        //Toast.makeText(this, "ID"+hotel_ID, Toast.LENGTH_SHORT).show();
        etdest.getEditText().setText(db.getNameofHotel(hotel_ID));
        //Toast.makeText(this, db.getNameofHotel(hotel_ID), Toast.LENGTH_SHORT).show();



    }
    public boolean cuoponApplied()
    {
        if(etcuopon.getEditText().getText().toString().isEmpty())
        {
            return false;
        }
        return  true;
    }

    public double TotalPrice(int hotelID,int rooms,int persons,long noOfDays)
    {
        double Lastprice=0;
        double price=0;

        ArrayList<Hotel> hotel=db.get_all_hotels();
        for(int i=0;i<hotel.size();i++)
        {
            if((hotel.get(i).getID()==hotelID)&&(cuoponApplied()))
            {
                Lastprice=rooms*noOfDays*persons*hotel.get(i).getPrice();

                if(db.is_Coupon_exist(etcuopon.getEditText().getText().toString()))
                {
                    Lastprice=Lastprice-((Lastprice) *(db.Coupon_Value(etcuopon.getEditText().getText().toString())));
                    //Toast.makeText(this, "Hotel: "+Lastprice, Toast.LENGTH_SHORT).show();
                    return Lastprice;
                }
                else
                {
                    Toast.makeText(this, "Enter valid Coupon", Toast.LENGTH_SHORT).show();
                }

            }
            else
            {
                Lastprice=(rooms*noOfDays*persons*hotel.get(i).getPrice());
                //Toast.makeText(this, "Last: "+Lastprice, Toast.LENGTH_SHORT).show();
                return Lastprice;
            }
        }
        return Lastprice;
    }


    @Override
    public void onClick(View v) {
        if(v==etchecin){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etchecin.getEditText().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            iday = dayOfMonth;
                            imonth = monthOfYear + 1;
                            iyear = year;
                            Calendar cal1 = (Calendar) Calendar.getInstance();
                            cal1.set(Calendar.MONTH, imonth - 1);
                            cal1.set(Calendar.YEAR, iyear);
                            cal1.set(Calendar.DAY_OF_MONTH, iday);
                            dt1 = cal1.getTime();
                                                 }
                    }, mYear, mMonth, mDay);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            datePickerDialog.show();


        }
        else if(v==etcheckout){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etcheckout.getEditText().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            oday = dayOfMonth;
                            omonth = monthOfYear + 1;
                            oyear = year;
                            Calendar cal1 = (Calendar) Calendar.getInstance();
                            cal1.set(Calendar.MONTH, omonth - 1);
                            cal1.set(Calendar.YEAR, oyear);
                            cal1.set(Calendar.DAY_OF_MONTH, oday);
                            dt2 = cal1.getTime();
                           // Toast.makeText(MainActivity.this, oday + " " + omonth + " " + oyear + " " + dt2, Toast.LENGTH_SHORT).show();
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            datePickerDialog.show();
        }
        else if (v==btnreserve){
            checkindate = etchecin.getEditText().getText().toString().trim();
            chectoutdate = etcheckout.getEditText().getText().toString().trim();
            dest = etdest.getEditText().getText().toString();
            nrooms = etrooms.getEditText().getText().toString().trim();
            npersons = etpersons.getEditText().getText().toString().trim();
            if (etchecin.getEditText().getText().toString().isEmpty() || etcheckout.getEditText().getText().toString().isEmpty() || etpersons.getEditText().getText().toString().isEmpty() || etrooms.getEditText().getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!db.checkAvailableRoomnumber(hotel_ID, Integer.parseInt(nrooms))) {
                Toast.makeText(MainActivity.this, "Please Enter less than or equal rooms"+db.getAvailablerooms2(hotel_ID), Toast.LENGTH_SHORT).show();
                return;
            }
            if (!db.checkAvailablePersonsPernumber(hotel_ID, Integer.parseInt(npersons))) {
                Toast.makeText(MainActivity.this, "Please Enter less than or equal "+db.getpersonsperrooms(hotel_ID)+" in persons", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!dt2.after(dt1)) {
                Toast.makeText(MainActivity.this, "Enter Correct date", Toast.LENGTH_SHORT).show();
                return;
            } else {
                diffDays=  CancelRent(dt1,dt2);
                tvfees.setText(String.valueOf(TotalPrice(hotel_ID,Integer.parseInt(nrooms),Integer.parseInt(npersons),diffDays)));

                //Toast.makeText(this, "Reserved "+diffDays, Toast.LENGTH_SHORT).show();
                showDialog();
                db.addReservation(String.valueOf(user_ID),String.valueOf(hotel_ID),checkindate,chectoutdate,nrooms);


            }
            /*checkindate=etchecin.getEditText().getText().toString().trim();
            chectoutdate=etcheckout.getEditText().getText().toString().trim();
            dest=etdest.getEditText().getText().toString().trim();
            nrooms=etrooms.getEditText().getText().toString().trim();
            npersons=etpersons.getEditText().getText().toString().trim();*/
            // elmfrood ba2a b3d ma t5dy elstrings deh tb3tih f function add ll database
        }
    }
    public long CancelRent(Date dt1,Date dt2){
        int day=dt1.getDate();
        int month=dt1.getMonth()+1;
        int year=dt1.getYear()+1900;
        Calendar cal1 = (Calendar)Calendar.getInstance();
        cal1.set(Calendar.MONTH, month-1);
        cal1.set(Calendar.YEAR, year);
        cal1.set(Calendar.DAY_OF_MONTH, day);
        dt1 = cal1.getTime();
        int day2=dt2.getDate();
        int month2=dt2.getMonth()+1;
        int year2=dt2.getYear()+1900;
        Calendar cal2 = (Calendar)Calendar.getInstance();
        cal2.set(Calendar.MONTH, month2-1);
        cal2.set(Calendar.YEAR, year2);
        cal2.set(Calendar.DAY_OF_MONTH, day2);
        dt2 = cal2.getTime();
       // Date d1=new Date();
        long diff = dt2.getTime() - dt1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        /*if(diffDays>=2)
            return true;
        return false;*/
        return diffDays;
    }

    private void showDialog() {
        ReseveDialog dialogReserve = new ReseveDialog() ;
        dialogReserve.show(getSupportFragmentManager() , "Example Dialog");
    }
}