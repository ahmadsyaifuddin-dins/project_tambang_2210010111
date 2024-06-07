package tambang_model;

//import Koneksi.Database; // Import kelas Database
//import java.sql.DriverManager; //menghubungkan database 
import java.sql.Connection; //mendapatkan koneksi
import java.sql.Date; // Menyimpan dan mengambil tanggal dari database.
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus
import java.sql.ResultSet; // untuk mengambil data pada satu record
import java.sql.Statement; // untuk mengambil keseluruhan data pada suatu table
import java.time.LocalDate; // Mendapatkan tanggal saat ini

public class coal_getting {
    private Connection KoneksiDB;

    public coal_getting(Connection KoneksiDB){
        this.KoneksiDB = KoneksiDB;
    }

    public void simpanCoal(int paramId, LocalDate paramTanggal, String paramMaterial, int paramQty, String paramType, String paramPit) {
        try {
            String SQL = "INSERT INTO coal_getting (id, date, material, qty, type, pit) VALUES(?,?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setDate(2, Date.valueOf(paramTanggal));
            perintah.setString(3, paramMaterial);
            perintah.setInt(4, paramQty);
            perintah.setString(5, paramType);
            perintah.setString(6, paramPit);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCoal(int paramId, LocalDate paramTanggal, String paramMaterial, int paramQty, String paramType, String paramPit) {
        try {
            String SQL = "UPDATE coal_getting SET date =?, material=?, qty=?, type=?, pit=? WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setDate(1, Date.valueOf(paramTanggal));
            perintah.setString(2, paramMaterial);
            perintah.setInt(3, paramQty);
            perintah.setString(4, paramType);
            perintah.setString(5, paramPit);
            perintah.setInt(6, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusCoal(int paramId) {
        try {
            String SQL = "DELETE FROM coal_getting WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cariCoal(String paramId){
        try {
            String SQL = "SELECT * FROM coal_getting WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramId);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("id :"+data.getString("id"));
                System.out.println("Date :"+data.getString("date"));
                System.out.println("Material :"+data.getString("material"));
                System.out.println("qty :"+data.getString("qty"));
                System.out.println("Type :"+data.getString("type"));
                System.out.println("Pit :"+data.getString("pit"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void dataCoal(){
        try {
            Statement stmt = KoneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM coal_getting ORDER BY id ASC");
            while (baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("date")+" | "+
                        baris.getString("material")+" | "+
                        baris.getString("qty")+" | "+
                        baris.getString("type")+" | "+
                        baris.getString("pit"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
