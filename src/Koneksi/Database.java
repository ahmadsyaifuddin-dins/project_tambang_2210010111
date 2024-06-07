package Koneksi;

import java.sql.Connection; // mendapatkan koneksi
import java.sql.DriverManager; // menghubungkan database
//import java.sql.Date; // menyimpan dan mengambil tanggal dari database
//import java.sql.PreparedStatement; // perintah sql simpan, ubah, hapus
//import java.sql.ResultSet; // untuk mengambil data pada satu record
//import java.sql.Statement; // untuk mengambil keseluruhan data pada suatu table
/**
 *
 * @author User
 */
public class Database {

    private String databaseName = "2210010111_tambang";
    private String username = "root";
    private String pass = "";
    private String lokasi = "jdbc:mysql://localhost:3306/" + databaseName;
    public static Connection KoneksiDB;

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            KoneksiDB = DriverManager.getConnection(lokasi, username, pass);
//            JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Database Terkoneksi!");
            
        } catch (Exception e) {
            System.err.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}