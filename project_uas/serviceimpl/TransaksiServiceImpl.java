package com.itenas.project_uas.serviceimpl;

import com.itenas.project_uas.pojo.Transaksi;
import com.itenas.project_uas.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itenas.project_uas.service.TransaksiService;

public class TransaksiServiceImpl implements TransaksiService{

    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public List<Transaksi> findAll() {
        List<Transaksi> listTransaksi = new ArrayList<>();
        String query = "SELECT * FROM `coffee_shop`.`transaksi`";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.setQuantity(rs.getInt("quantity"));
                transaksi.setTotalHarga(rs.getDouble("totalHarga"));
                transaksi.setTanggal(rs.getString("tanggal"));
                listTransaksi.add(transaksi);

            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return listTransaksi;
        }

    @Override
    public Integer create(Transaksi object) {
    int result = 0;
        String sql = "INSERT INTO `coffee_shop`.`transaksi` (`idTransaksi`, `quantity`, `totalHarga`, `tanggal`)"
                + "VALUES( "+object.getIdTransaksi()+","
                + ""+object.getQuantity()+","
                + "'"+object.getTotalHarga()+"',"
                + "'"+object.getTanggal()+"');";
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Transaksi object) {
        int result = 0;
        String sql = "UPDATE `coffee_shop`.`transaksi` SET `quantity`='"+object.getQuantity()+"',"
                + " `totalHarga`="+object.getTotalHarga()+","
                + " `tanggal`='"+object.getTanggal()+"'"
                + " WHERE id="+object.getIdTransaksi()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Transaksi findById(int idTransaksi) {
        Transaksi transaksi = null;
        String sql = "SELECT * FROM `coffee_shop`.`transaksi` WHERE `idTransaksi`="+idTransaksi+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.setQuantity(rs.getInt("quantity"));
                transaksi.setTotalHarga(rs.getDouble("totalHarga"));
                transaksi.setTanggal(rs.getString("tanggal"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return transaksi;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM `coffee_shop`.`transaksi` WHERE  `idTransaksi`="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }   
}