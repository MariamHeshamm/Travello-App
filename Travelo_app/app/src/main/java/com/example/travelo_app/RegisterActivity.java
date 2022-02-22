package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    TextInputLayout et_Email,et_name;
    DatabaseHelper db;

    TextInputLayout et_password;
    TextInputLayout et_confirmpass,et_phone;
    Button btn_signup;
    TextView tvSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        et_Email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        et_confirmpass=findViewById(R.id.et_password2);
        btn_signup=findViewById(R.id.btn_register);
        tvSignin=findViewById(R.id.tv_signin);
        et_phone=findViewById(R.id.et_phone);
        et_name=findViewById(R.id.et_username);
        db=new DatabaseHelper(this);
        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent (RegisterActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_Email.getEditText().getText().toString().isEmpty()||et_password.getEditText().getText().toString().isEmpty()||et_confirmpass.getEditText().getText().toString().isEmpty()||et_phone.getEditText().getText().toString().isEmpty()||et_name.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String user = et_Email.getEditText().getText().toString();
                    String user_name=et_name.getEditText().getText().toString();
                    String phone=et_phone.getEditText().getText().toString().trim();
                    String pass = et_password.getEditText().getText().toString();
                    String pass2 = et_confirmpass.getEditText().getText().toString();
                    boolean b1=isEmail(user);
                    if(b1==false){
                        Toast.makeText(RegisterActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    boolean b2=db.checkEmail(et_Email.getEditText().getText().toString());
                    if(b2==true){
                        Toast.makeText(RegisterActivity.this, "Enter another email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    boolean b3=db.checkPhone(et_phone.getEditText().getText().toString());
                    if(b1==false){
                        Toast.makeText(RegisterActivity.this, "Enter another phone number", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (pass.equals(pass2)) {
                        long val = db.addUser(user, pass,phone,user_name);
                        if (val > 0) {
                            Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent movetologin = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(movetologin);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registeration error", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    boolean isEmail (String email) {
        //   String email=text.getText().toString();
        //  CharSequence email = text.getText().toString();
        //  return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        //  boolean correct=Patterns.EMAIL_ADDRESS.matcher(email).matches();
        //return correct;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
