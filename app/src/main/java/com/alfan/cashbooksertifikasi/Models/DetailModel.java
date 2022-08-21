package com.alfan.cashbooksertifikasi.Models;
import java.util.Date;
public class DetailModel {
    private String id;
    private double jumlah;
    private String keterangan;
    private String tanggal;
    private int cursor;

    public DetailModel(String id,  double jumlah, String keterangan, String tanggal, int cursor) {
        this.id = id;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
        this.cursor = cursor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    //    public DetailModel(double jumlah, String keterangan, String tanggal, int cursor) {
//        this.jumlah = jumlah;
//        this.keterangan = keterangan;
//        this.tanggal = tanggal;
//        this.cursor = cursor;
//    }
//
//    public double getJumlah() {
//        return jumlah;
//    }
//
//    public void setJumlah(double jumlah) {
//        this.jumlah = jumlah;
//    }
//
//    public String getKeterangan() {
//        return keterangan;
//    }
//
//    public void setKeterangan(String keterangan) {
//        this.keterangan = keterangan;
//    }
//
//    public String getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(String tanggal) {
//        this.tanggal = tanggal;
//    }
//
//    public int getCursor() {
//        return cursor;
//    }
//
//    public void setCursor(int cursor) {
//        this.cursor = cursor;
//    }
}
