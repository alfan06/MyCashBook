package com.alfan.cashbooksertifikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.alfan.cashbooksertifikasi.DB.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PemasukanActivity extends AppCompatActivity {
    DBHelper db;
    DatePickerDialog tanggalPicker;
    SimpleDateFormat formatTanggal;
    Button btn_back, btn_simpan;
    EditText tanggal,nominal,keterangan;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);

        db = new DBHelper(this);

        id = getIntent().getLongExtra(db.id_pemasukan, 0);

        tanggal = (EditText)findViewById(R.id.tanggal);
        nominal = (EditText)findViewById(R.id.nominal);
        keterangan = (EditText)findViewById(R.id.keterangan);
        btn_back =  (Button)findViewById(R.id.btn_back);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);
        formatTanggal = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back();
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_simpan();
            }
        });
    }

    private void showDateDialog() {
        Calendar calendar = Calendar.getInstance();

        tanggalPicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                tanggal.setText(formatTanggal.format(newDate.getTime()));
            }
        },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        tanggalPicker.show();
    }

    private void btn_simpan() {
        Double pnglrn = Double.valueOf(nominal.getText().toString().trim());
        String desc = keterangan.getText().toString().trim();
        String tgl = tanggal.getText().toString().trim();

        //ContentValues values = new ContentValues();
        //values.put(db.tambahPemasukan(tgl, pnglrn, desc ));
        boolean insertPemasukan = db.tambahPemasukan(tgl, pnglrn, desc);
        if (insertPemasukan){
            Toast.makeText(PemasukanActivity.this, "Data Pemasukan Tersimpan", Toast.LENGTH_SHORT);
            Intent mainIntent = new Intent(PemasukanActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        } else {
            Toast.makeText(PemasukanActivity.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }

    private void btn_back() {
        Intent intent = new Intent(PemasukanActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}