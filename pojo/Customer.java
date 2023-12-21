package com.itenas.projek_uas.pojo;

public class Customer {
    private String id;
    private String nama;
    private Integer nomorTelepon;
    private String alamat;
    
    public Customer() {
    }

    public Customer(String id, String nama, Integer nomorTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getKontak() {
        return nomorTelepon;
    }

    public void setKontak(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
