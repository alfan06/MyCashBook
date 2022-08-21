package com.alfan.cashbooksertifikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PengaturanActivity extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPreferences";
    Button btn_back,btn_simpan, btn_logout;
    EditText old_pass, new_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_simpan = (Button)findViewById(R.id.btn_simpan);
        btn_logout = (Button)findViewById(R.id.button);
        old_pass = (EditText) findViewById(R.id.old_pass);
        new_pass = (EditText) findViewById(R.id.new_pass);

        SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final String password = preferences.getString("password", "alfan");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backPengaturanIntent = new Intent(PengaturanActivity.this, MainActivity.class);
                startActivity(backPengaturanIntent);
                finish();
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (old_pass.getText().toString().equals(password)){
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("username", "alfan");
                    editor.putString("password",new_pass.getText().toString());
                    editor.apply();
                    Toast.makeText(getBaseContext(), "Password berhasil diubah!", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(PengaturanActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(), "Password tidak sama!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show();
                Intent backPengaturanIntent = new Intent(PengaturanActivity.this, LoginActivity.class);
                startActivity(backPengaturanIntent);
                finish();
            }
        });
    }
}