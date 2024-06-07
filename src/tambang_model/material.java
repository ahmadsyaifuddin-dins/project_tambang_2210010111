package tambang_model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class material {
    private Connection KoneksiDB;

    // Konstruktor untuk menerima objek koneksi
    public material(Connection KoneksiDB) {
        this.KoneksiDB = KoneksiDB;
    }

    public void simpanMaterial(String paramCodeMat, String paramDescMat, String paramCompMat, LocalDate paramCreate) {
        try {
            String SQL = "INSERT INTO material (code_material, desc_material, comp_material, created_at) VALUES(?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeMat);
            perintah.setString(2, paramDescMat);
            perintah.setString(3, paramCompMat);
            perintah.setDate(4, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMaterial(String paramCodeMat, String paramDescMat, String paramCompMat, LocalDate paramCreate) {
        try {
            String SQL = "UPDATE material SET desc_material=?, comp_material=?, created_at=? WHERE code_material=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramDescMat);
            perintah.setString(2, paramCompMat);
            perintah.setDate(3, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.setString(4, paramCodeMat);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusMaterial(String paramCodeMat) {
        try {
            String SQL = "DELETE FROM material WHERE code_material=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeMat);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cariMaterial(String paramCodeMat) {
        try {
            String SQL = "SELECT * FROM material WHERE code_material=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeMat);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("code_material :" + data.getString("code_material"));
                System.out.println("desc_material :" + data.getString("desc_material"));
                System.out.println("comp_material :" + data.getString("comp_material"));
                System.out.println("created_at :" + data.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void dataMaterial() {
        try {
            Statement stmt = KoneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM material ORDER BY code_material ASC");
            while (baris.next()) {
                System.out.println(baris.getString("code_material") + " | " +
                        baris.getString("desc_material") + " | " +
                        baris.getString("comp_material") + " | " +
                        baris.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
