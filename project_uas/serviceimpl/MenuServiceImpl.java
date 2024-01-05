package com.itenas.project_uas.serviceimpl;

import com.itenas.project_uas.pojo.Menu;
import com.itenas.project_uas.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itenas.project_uas.service.MenuService;

public class MenuServiceImpl implements MenuService {

    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Menu> findAll() {
        List<Menu> listMenu = new ArrayList<>();
        String query = "SELECT * FROM `coffee_shop`.`menu`";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setNamaMenu(rs.getString("namaMenu"));
                menu.setKategori(rs.getString("kategori"));
                menu.setHarga(rs.getDouble("harga"));
                menu.setStok(rs.getInt("stok"));
                listMenu.add(menu);

            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return listMenu;
    }

    @Override
    public Integer create(Menu object) {
        int result = 0;
        String sql = "INSERT INTO `coffee_shop`.`menu` (`namaMenu`, `kategori`, `harga`, `stok`) "
                + "VALUES('"+object.getNamaMenu()+"', "
                + "'"+object.getKategori()+"', "
                + ""+object.getHarga()+", "
                + ""+object.getStok()+")";
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Menu object) {
        int result = 0;
        String sql = "UPDATE `coffee_shop`.`menu` SET `namaMenu`='"+object.getNamaMenu()+"',"
                + " `kategori`='"+object.getKategori()+"',"
                + " `harga`="+object.getHarga()+","
                + " `stok`='"+object.getStok()+"'"
                + " WHERE `idMenu`="+object.getIdMenu()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Menu findById(int id) {
        Menu menu = null;
        String sql = "SELECT * FROM `coffee_shop`.`menu` WHERE `idMenu`="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                menu = new Menu();
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setNamaMenu(rs.getString("NamaMenu"));
                menu.setKategori(rs.getString("Kategori"));
                menu.setHarga(rs.getDouble("Harga"));
                menu.setStok(rs.getInt("Stok"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return menu;
    }

    @Override
    public Integer delete(int idMenu) {
        int result = 0;
        String sql = "DELETE FROM `coffee_shop`.`menu` WHERE `idMenu`="+idMenu+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
}