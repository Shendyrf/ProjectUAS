package com.itenas.project_uas.serviceimpl;

import com.itenas.project_uas.pojo.Akun;
import com.itenas.project_uas.pojo.Kasir;
import com.itenas.project_uas.service.KasirService;
import com.itenas.project_uas.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KasirServiceImpl implements KasirService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public Kasir login(String username, String password) {
        Kasir kasir = null;
        Akun akun = null;
        String sql = "SELECT * FROM akun"
                + "WHERE username = '"+username+"' "
                + "AND WHERE password = '"+password+"';";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                kasir = new Kasir();
                kasir.setIdKasir(rs.getInt("idKasir"));
                kasir.setNama(rs.getString("nama"));
                akun = new Akun();
                akun.setIdAkun(rs.getInt("idAkun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setPeran(rs.getString("peran"));
                kasir.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return kasir;
    }

    @Override
    public Integer register(Kasir object) {
        int stat = 0;

        String sql = "INSERT INTO akun (idAkun,email, username, password, peran) "
                + "VALUES ('"+object.getAkun().getIdAkun()+"',"
                + "'"+object.getAkun().getEmail()+"', "
                + "'"+object.getAkun().getUsername()+"', "
                + "'"+object.getAkun().getPassword()+"', "
                + "'"+object.getAkun().getPeran()+"');";
        
        String sql1 = "INSERT INTO kasir (idKasir, nama, umur, jenisKelamin, nomorTelepon, alamat, tanggalLahir, idAkun) "
                + "VALUES ('"+object.getIdKasir()+"', "
                + "'"+object.getNama()+"', "
                + "'"+object.getUmur()+"', "
                + "'"+object.getJenisKelamin()+"', "
                + "'"+object.getNomerTelepon()+"', "
                + "'"+object.getAlamat()+"', "
                + "'"+object.getTanggalLahir()+"',"
                + "'"+object.getAkun().getIdAkun()+"'); ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null,ex);
        }
        return stat;
    }
       
}
        
        
