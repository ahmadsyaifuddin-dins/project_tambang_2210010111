package tambang_model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class location {
    private Connection KoneksiDB;

    // Konstruktor untuk menerima objek koneksi
    public location(Connection KoneksiDB) {
        this.KoneksiDB = KoneksiDB;
    }

    public void simpanLocation(String paramCodeLoc, String paramDescLoc, LocalDate paramCreate) {
        try {
            String SQL = "INSERT INTO location (code_location, desc_location, created_at) VALUES(?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeLoc);
            perintah.setString(2, paramDescLoc);
            perintah.setDate(3, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLocation(String paramCodeLoc, String paramDescLoc, LocalDate paramCreate) {
        try {
            String SQL = "UPDATE location SET desc_location=?, created_at=? WHERE code_location=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramDescLoc);
            perintah.setDate(2, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.setString(3, paramCodeLoc);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusLocation(String paramCodeLoc) {
        try {
            String SQL = "DELETE FROM location WHERE code_location=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeLoc);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cariLocation(String paramCodeLoc) {
        try {
            String SQL = "SELECT * FROM location WHERE code_location=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeLoc);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("code_location :" + data.getString("code_location"));
                System.out.println("desc_location :" + data.getString("desc_location"));
                System.out.println("created_at :" + data.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void dataLocation() {
        try {
            Statement stmt = KoneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM location ORDER BY code_location ASC");
            while (baris.next()) {
                System.out.println(baris.getString("code_location") + " | " +
                        baris.getString("code_location") + " | " +
                        baris.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
