package com.alfan.cashbooksertifikasi.DB;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.alfan.cashbooksertifikasi.Models.DetailModel;

import java.util.ArrayList;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    //deklarasi database
    static final String database = "mycb.DB";
    static final int versi_Db = 1;
    public static final String id_pemasukan = "id";
    public static final String id_pengeluaran = "id";


    public DBHelper(Context context) {
        super(context, database, null, versi_Db);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pemasukan(id INTEGER PRIMARY KEY AUTOINCREMENT, tanggalPemasukan DATE NOT NULL, jumlahPemasukan DOUBLE NOT NULL, keterangan TEXT)");
        db.execSQL("CREATE TABLE pengeluaran(id INTEGER PRIMARY KEY AUTOINCREMENT, tanggalPengeluaran DATE NOT NULL, jumlahPengeluaran DOUBLE NOT NULL, keterangan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int insert1, int insert2) {
        db.execSQL("DROP TABLE IF EXISTS pemasukan");
        db.execSQL("DROP TABLE IF EXISTS pengeluaran");
        onCreate(db);
    }

    public boolean tambahPemasukan(String tanggalPemasukan, double jumlahPemasukan, String Keterangan) {
        ContentValues values = new ContentValues();
        values.put("tanggalPemasukan", String.valueOf(tanggalPemasukan));
        values.put("jumlahPemasukan", jumlahPemasukan);
        values.put("keterangan", Keterangan);
        long hasil;
        hasil = db.insert("pemasukan", null, values);
        if (hasil  == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean tambahPengeluaran(String tanggalPengeluaran, double jumlahPengeluaran, String keterangan) {
        ContentValues values = new ContentValues();
        values.put("tanggalPengeluaran", String.valueOf(tanggalPengeluaran));
        values.put("jumlahPengeluaran", jumlahPengeluaran);
        values.put("keterangan", keterangan);
        long hasil;
        hasil = db.insert("pengeluaran", null, values);
        if (hasil == -1){
            return false;
        }else{
            return true;
        }
    }

    public int totalPemasukan(){
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(jumlahPemasukan) as nominal FROM pemasukan", null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        return result;
    }

    public int totalPengeluaran(){
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(jumlahPengeluaran) as nominal FROM pengeluaran", null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        return result;
    }

    public int cek(){
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, tanggalPemasukan as tgl_pemasukan, jumlahPemasukan as nominalPemasukan, keterangan as description,0 as cursor from  pemasukan"
                + " union select id, tanggalPengeluaran as tgl_pengeluaran, jumlahPengeluaran as nominalPengeluaran, keterangan as description, 1 as cursor from pengeluaran", null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        return result;
    }

    public ArrayList<DetailModel> detail (){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<DetailModel> DetailArrayList = new ArrayList<>();

        Cursor list = db.rawQuery("SELECT id, jumlahPemasukan as nominalPemasukan,tanggalPemasukan as tgl_pemasukan,  keterangan as description,0 as cursor from  pemasukan"
               + " union select id, jumlahPengeluaran as nominalPengeluaran,tanggalPengeluaran as tgl_pengeluaran,  keterangan as description, 1 as cursor from pengeluaran", null);
        if (list.moveToFirst()) {
            do {
                DetailArrayList.add(new DetailModel(list.getString(0),
                        list.getDouble(1),
                        list.getString(2),
                        list.getString(3),
                        list.getInt(4)));
            }while (list.moveToNext());
        }
        list.close();
        return DetailArrayList;
    }


}
