package com.alfan.cashbooksertifikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alfan.cashbooksertifikasi.DB.DBHelper;

public class LoginActivity extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPreferences";
    DBHelper db;
    Button btn_login;
    EditText uname,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);

        btn_login = (Button)findViewById(R.id.btn_login);
        uname = (EditText)findViewById(R.id.username);
        pwd = (EditText)findViewById(R.id.password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = uname.getText().toString();
                String strPassword = pwd.getText().toString();

                SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String prefUser = preferences.getString("username", "alfan");
                String prefPass = preferences.getString("password", "alfan");

                if (strUsername.equals(prefUser) && strPassword.equals(prefPass)){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "Username atau password salah!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}