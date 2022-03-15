/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author soto.aitzol
 */
public class Model {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/pkg1/Hiztegia4.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    
   public void terminoaGehitu(Terminoa t) {
        String sql = "INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, t.getEuskaraz());
            pstmt.setString(2, t.getGazteleraz());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void terminoakInprimatu() {
        ArrayList<Terminoa> terminoak = new ArrayList();
        String sql = "SELECT id, euskaraz, gazteleraz FROM Terminoak";
        int guztira = 0;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            System.out.printf("%12s %12s %12s", "ID", "EUSKARAZ", "GAZTELERAZ");
            System.out.printf("\n--------------------------------------------");
            // loop through the result set
            while (rs.next()) {
                Terminoa t1 = new Terminoa(rs.getInt("id"),rs.getString("euskaraz"),rs.getString("gazteleraz"));
                terminoak.add(t1);
                System.out.printf("\n%12d %12s %12s", t1.getId(), t1.getEuskaraz(), t1.getGazteleraz());
                guztira++;
            }
            System.out.printf("\n--------------------------------------------\n");
            System.out.println("GUZTIRA: " + guztira);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void terminoaEzabatu(int id) {
        String sql = "DELETE FROM Terminoak WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void terminoaAldatu(int id, String euskaraz, String gazteleraz) {
        String sql = "UPDATE Terminoak SET euskaraz = ? , "
                + "gazteleraz = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, euskaraz);
            pstmt.setString(2, gazteleraz);
            pstmt.setInt(3, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
