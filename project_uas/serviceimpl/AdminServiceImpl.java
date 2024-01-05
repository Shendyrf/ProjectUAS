package com.itenas.project_uas.serviceimpl;

import com.itenas.project_uas.pojo.Admin;
import com.itenas.project_uas.pojo.Akun;
import com.itenas.project_uas.service.AdminService;
import com.itenas.project_uas.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServiceImpl implements AdminService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs; 

    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        Akun akun = null;
        String sql = "SELECT `admin`.`idAdmin`, `admin`.`namaDepan`,`admin`.`namaBelakang`, "
                + "`akun`.`idAkun`,`akun`.`email`, `akun`.`username`,`akun`.`password`,`akun`.`peran` "
                + "FROM `coffee_shop`.`admin`,`coffee_shop`.`akun` "
                + "WHERE admin.idAkun = akun.idAkun "
                + "AND akun.username = '"+username+"' "
                + "AND akun.password = '"+password+"'";
                
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("idAdmin"));
                admin.setNamaDepan(rs.getString("namaDapan"));
                admin.setNamaBelakang(rs.getString("namaBelakang"));
                akun = new Akun();
                akun.setIdAkun(rs.getInt("idAkun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPeran(rs.getString("peran"));
                admin.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return admin;
    }
}
