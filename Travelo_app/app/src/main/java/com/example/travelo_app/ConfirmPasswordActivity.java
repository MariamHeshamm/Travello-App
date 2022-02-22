package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ConfirmPasswordActivity extends AppCompatActivity {
    TextInputLayout et_pass1,et_pass2;
    DatabaseHelper db;
    String email;
    Button btn_reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);
        et_pass1=findViewById(R.id.et_password);
        et_pass2=findViewById(R.id.et_password2);
        db=new DatabaseHelper(this);
        Intent intent=getIntent();
        email=intent.getStringExtra("EMAIL");
        btn_reset=findViewById(R.id.btn_resetpass);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Updatepassword();
            }
        });
    }
    private void Updatepassword(){
        String pass1=et_pass1.getEditText().getText().toString().trim();
        String pass2=et_pass2.getEditText().getText().toString().trim();
        if(et_pass1.getEditText().getText().toString().isEmpty()||et_pass2.getEditText().getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!pass1.equals(pass2)){
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
        }
        else {
            db.UpdatePassword(email,pass1);
            Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show();
            et_pass1.getEditText().setText("");
            et_pass2.getEditText().setText("");
            Intent i=new Intent(this, LogoActivity.class);
            startActivity(i);
            finish();
        }
    }
}