package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ForgetPasswordActivity extends AppCompatActivity {
    TextInputLayout et_email;
    Button btn_confirm;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        et_email=findViewById(R.id.et_confirmmail);
        btn_confirm=findViewById(R.id.btn_confimmail);
        db=new DatabaseHelper(this);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyfromSQLite();
            }
        });
    }
    private void  verifyfromSQLite(){
        if(et_email.getEditText().getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(db.checkEmail(et_email.getEditText().getText().toString().trim())){
            Intent i=new Intent(this,ConfirmPasswordActivity.class);
            i.putExtra("EMAIL",et_email.getEditText().getText().toString().trim());
            et_email.getEditText().setText("");
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Wrong email", Toast.LENGTH_SHORT).show();
        }
    }
}
