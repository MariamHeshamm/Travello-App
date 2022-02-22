package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout etEmail,etPassword;
    String user="";
    String id="";
    Button btn_login;//
    TextView tvRegister,tv_forget;
    CheckBox remember;
    SharedPreferences mPrefs;
    static final String PREFS_NAME="PrefsFile";

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.tv_register);
        tv_forget=findViewById(R.id.tv_forget);
        remember=findViewById(R.id.rememberbox);
        mPrefs=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        // btn_delete=findViewById(R.id.btn_delete);
        db=new DatabaseHelper(this);
        getPreferencesData();
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEmail.getEditText().getText().toString().isEmpty()||etPassword.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    user = etEmail.getEditText().getText().toString().trim();
                    boolean ismail = isEmail(etEmail);
                    if (ismail == false) {
                        Toast.makeText(LoginActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                    }
                    String pwd = etPassword.getEditText().getText().toString().trim();
                    Boolean res = db.Checkuser(user, pwd);
                    if (res == true) {
                        //Toast.makeText(LoginActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                        id=db.getID(user);
                        //Toast.makeText(LoginActivity.this, "ID:"+db.getID(user), Toast.LENGTH_SHORT).show();
                        Intent ToHotelDescription=new Intent(LoginActivity.this, BottomNavigationActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("ID", id);
                        ToHotelDescription.putExtras(bundle);
                        startActivity(ToHotelDescription);
                        finish();

                        if( remember.isChecked()){
                            Boolean boolisChecked=remember.isChecked();
                            SharedPreferences.Editor editor =mPrefs.edit();
                            editor.putString("pref_email",etEmail.getEditText().getText().toString());
                            editor.putString("pref_pass",etPassword.getEditText().getText().toString());
                            editor.putBoolean("pref_check",boolisChecked);
                            editor.apply();
                            //Toast.makeText(getApplicationContext(), "Settings have been saved", Toast.LENGTH_SHORT).show();


                        }
                        else {
                            mPrefs.edit().clear().apply();

                        }
                        etEmail.getEditText().setText("");
                        etPassword.getEditText().setText("");
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(i);
            }
        });
    }
    public void getPreferencesData(){
        SharedPreferences sp=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("pref_email")){
            String email=sp.getString("pref_email","not found");
            etEmail.getEditText().setText(email.toString());
        }
        if(sp.contains("pref_pass")){
            String pass=sp.getString("pref_pass","not found");
            etPassword.getEditText().setText(pass.toString());
        }
        if(sp.contains("pref_check")){
            Boolean check=sp.getBoolean("pref_check",false);
            remember.setChecked(check);
        }
    }

    /*public  boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/
    boolean isEmail (TextInputLayout text) {
        CharSequence email = text.getEditText().getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
