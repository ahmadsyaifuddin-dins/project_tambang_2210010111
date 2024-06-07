package tambang_model;

import java.sql.Connection; //mendapatkan koneksi
import java.sql.Date; // Menyimpan dan mengambil tanggal dari database.
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus
import java.sql.ResultSet; // untuk mengambil data pada satu record
import java.sql.Statement; // untuk mengambil keseluruhan data pada suatu table
import java.time.LocalDate; // Mendapatkan tanggal saat ini

public class company {
    private Connection KoneksiDB;

    // Konstruktor untuk menerima objek koneksi
    public company(Connection KoneksiDB) {
        this.KoneksiDB = KoneksiDB;
    }

    public void simpanCompany(int paramId, String paramCodeCom, String paramDescCom, LocalDate paramCreate) {
        try {
            String SQL = "INSERT INTO company (id, code_company, desc_company, created_at) VALUES(?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, paramCodeCom);
            perintah.setString(3, paramDescCom);
            perintah.setDate(4, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCompany(int paramId, String paramCodeCom, String paramDescCom, LocalDate paramCreate) {
        try {
            String SQL = "UPDATE company SET code_company =?, desc_company=?, created_at=? WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeCom);
            perintah.setString(2, paramDescCom);
            perintah.setDate(3, Date.valueOf(paramCreate)); // Konversi LocalDate ke java.sql.Date
            perintah.setInt(4, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusCompany(int paramId) {
        try {
            String SQL = "DELETE FROM company WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cariCompany(String paramId) {
        try {
            String SQL = "SELECT * FROM company WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramId);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("id :" + data.getString("id"));
                System.out.println("code_company :" + data.getString("code_company"));
                System.out.println("desc_company :" + data.getString("desc_company"));
                System.out.println("created_at :" + data.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void dataCompany() {
        try {
            Statement stmt = KoneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM company ORDER BY id ASC");
            while (baris.next()) {
                System.out.println(baris.getString("id") + " | " +
                        baris.getString("code_company") + " | " +
                        baris.getString("desc_company") + " | " +
                        baris.getString("created_at"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
