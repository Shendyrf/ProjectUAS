package com.itenas.project_uas.pojo;

public class Admin {
    private Integer idAdmin;
    private String namaDepan;
    private String namaBelakang;
    private boolean loginStatus;
    private Akun akun;

    public Admin() {
    
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
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