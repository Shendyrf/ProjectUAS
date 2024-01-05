package com.itenas.project_uas.pojo;

public class Kasir {
    private Integer idKasir;
    private String nama;
    private int umur;
    private String jenisKelamin;
    private String nomerTelepon;
    private String alamat;
    private String tanggalLahir;
    private boolean loginStatus;
    private Akun akun;

    public Kasir() {
    }
    
    public Integer getIdKasir() {
        return idKasir;
    }

    public void setIdKasir(Integer idKasir) {
        this.idKasir = idKasir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNomerTelepon() {
        return nomerTelepon;
    }

    public void setNomerTelepon(String nomerTelepon) {
        this.nomerTelepon = nomerTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }
    
}