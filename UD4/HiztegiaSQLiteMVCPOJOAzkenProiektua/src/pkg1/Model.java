package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {

    private final String DB = "db/Hiztegia.db";

    public Connection konektatu() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + DB;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            //  System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }

    public void terminoakInprimatu() {
        String taula = "Terminoak";
        String sql = "SELECT * FROM " + taula;

        try ( Connection conn = konektatu();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            //Txostenaren izenburua
            String izenburua = DB + " datu-baseko " + taula + " taulako datuak:";
            System.out.println(izenburua);
            for (int i = 0; i < izenburua.length(); i++) {
                System.out.print("=");
            }
            System.out.println("");

            int kont = 0;
            while (rs.next()) {
                Terminoa t = new Terminoa(rs.getInt("id"), rs.getString("euskaraz"), rs.getString("gazteleraz"));
                System.out.println(t);
                kont++;
            }
            for (int i = 0; i < izenburua.length(); i++) {
                System.out.print("-");
            }
            System.out.println("");
            System.out.println("GUZTIRA: " + kont + " termino");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static ArrayList<Terminoa> tBilatu(String hitza) {
//        String taula = "Terminoak";
//        String sql = "SELECT * FROM " + taula + " WHERE euskaraz= ? OR gazteleraz = ?";
//
//        ArrayList<Terminoa> alt = new ArrayList<>();
//        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//        } catch (Exception ex) {
//
//        }
//        return alt;
//    }
//    public static int tGehitu(Terminoa t) {
//
//        String sql = "INSERT INTO Terminoak(id,euskaraz,gazteleraz) VALUES(?,?,?)";
//
//        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, t.getId());
//            pstmt.setString(2, t.getEuskaraz());
//            pstmt.setString(3, t.getGazteleraz());
//            return pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return 0;
//        }
//
//    }
    public void terminoakInprimatuObjektuGabe() {
        String taula = "Terminoak";
        String sql = "SELECT * FROM " + taula;

        try ( Connection conn = konektatu();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            //Txostenaren izenburua
            String izenburua = DB + " datu-baseko " + taula + " taulako datuak:";
            System.out.println(izenburua);
            for (int i = 0; i < izenburua.length(); i++) {
                System.out.print("=");
            }
            System.out.println("");

            int kont = 0;
            while (rs.next()) {
                System.out.printf("%3d  %-30s%-30s\n", rs.getInt("id"), rs.getString("euskaraz"), rs.getString("gazteleraz"));
                kont++;
            }
            for (int i = 0; i < izenburua.length(); i++) {
                System.out.print("-");
            }
            System.out.println("");
            System.out.println("GUZTIRA: " + kont + " termino");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void itzulpenaInprimatu(String euskarazkoa) {
        String taula = "Terminoak";
        String sql = "SELECT * FROM " + taula + " WHERE euskaraz= ?";

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, euskarazkoa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Terminoa t = new Terminoa(rs.getInt("id"), rs.getString("euskaraz"), rs.getString("gazteleraz"));
                System.out.println(t);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public int terminoaGehitu(Terminoa t) {

        String sql = "INSERT INTO Terminoak(id,euskaraz,gazteleraz) VALUES(?,?,?)";

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, terminoKopurua());
            pstmt.setString(2, t.getEuskaraz());
            pstmt.setString(3, t.getGazteleraz());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int terminoKopurua() {
        String taula = "Terminoak";
        String sql = "SELECT count(id) FROM " + taula;

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("count(id)");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public boolean terminoaErrepikatuta(String tEuskaraz, String tGazteleraz) {
        Terminoa t = new Terminoa(0, "", "");
        String taula = "Terminoak";
        String sql = "SELECT euskaraz, gazteleraz FROM " + taula + " where euskaraz = ? or gazteleraz = ?";

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tEuskaraz.toUpperCase());
            pstmt.setString(2, tGazteleraz.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int terminoaGehituObjektuGabe(int id, String euskaraz, String gazteleraz) {

        String sql = "INSERT INTO Terminoak(id,euskaraz,gazteleraz) VALUES(?,?,?)";

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1790);
            pstmt.setString(2, euskaraz);
            pstmt.setString(3, gazteleraz);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public int terminoaEzabatu(int id) {

        String sql = "DELETE FROM Terminoak WHERE id = ?";

        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    

    /**
     * Kontuz: lechuga');DELETE FROM Terminoak;--
     */
    public void metodoBat(String eu, String es) {

//        Scanner in = new Scanner(System.in);
//        System.out.print("Termino berria: ");
//        String strEu = in.nextLine();
//        String strEs = terminoa.split(" ");
        //String sql = "SELECT id,euskaraz,gazteleraz FROM Terminoak WHERE euskaraz = '"+ strEuskaraz+"'" ;
        String sql = "INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES('" + eu + "','" + es + "')";

        try ( Connection conn = konektatu();  Statement stmt = conn.createStatement()) {
            int n = stmt.executeUpdate(sql);

            //     System.out.println(strEuskaraz +" => " +rs.getString("gazteleraz"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String hitzaErakutsi() {
        ArrayList<Terminoa> erakustekoTerminoak = new ArrayList<>();
        String sql = "Select id,euskaraz from Terminoak";
        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Terminoa t = new Terminoa(rs.getInt("id"), rs.getString("euskaraz"), "");
                erakustekoTerminoak.add(t);
            }
            return erakustekoTerminoak.get((int) (Math.random() * erakustekoTerminoak.size())).getEuskaraz();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public boolean hitzaKonprobatu(String asmatuBeharrekoHitza, String sartutakoHitza) {
        Terminoa t = new Terminoa(0, "", "");
        String sql = "Select gazteleraz from Terminoak where euskaraz = ?";
        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asmatuBeharrekoHitza);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                t = new Terminoa(0, "", rs.getString("gazteleraz"));
            }

            if (sartutakoHitza.toLowerCase().equals(t.getGazteleraz().toLowerCase())) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Terminoa> terminoakTaulara(){ 
        ArrayList<Terminoa> terminoGuztiak = new ArrayList<>();
        String sql = "Select id,euskaraz,gazteleraz from Terminoak";
        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Terminoa t = new Terminoa(rs.getInt("id"), rs.getString("euskaraz"), rs.getString("gazteleraz"));
                terminoGuztiak.add(t);
            }
            return terminoGuztiak;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public String terminoaItzuliGaztelerara(String euskaraz){
        String sql = "Select euskaraz,gazteleraz from Terminoak where euskaraz = ?";
        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, euskaraz);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Terminoa t = new Terminoa(0, rs.getString("euskaraz"), rs.getString("gazteleraz"));
                return t.getGazteleraz();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    public String terminoaItzuliEuskerara(String gazteleraz){
        String sql = "Select euskaraz,gazteleraz from Terminoak where gazteleraz = ?";
        try ( Connection conn = konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gazteleraz);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Terminoa t = new Terminoa(0, rs.getString("euskaraz"), rs.getString("gazteleraz"));
                return t.getEuskaraz();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
