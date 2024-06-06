package Koneksi;

import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager;  //menghubungkan database
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus
import javax.swing.JOptionPane; // untuk menampilkan pesan informasi berupa (GUI)

// untuk mengambil data pada satu record
import java.sql.ResultSet;

// untuk mengambil keseluruhan data pada suatu table
import java.sql.Statement;

// Time/Date 
import java.time.LocalDate; // Mendapatkan tanggal saat ini
import java.sql.Date; // Menyimpan dan mengambil tanggal dari database.

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
    
//  Implementasi code untuk Tambah Data pada Table coal_getting
    public void simpanCoal(int paramId, LocalDate paramTanggal, String paramMaterial, int paramQty, String paramType, String paramPit) {
        try {
            String SQL = "INSERT INTO coal_getting (id, date, material, qty, type, pit) VALUES(?,?,?,?,?,?)";
            
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setDate(2, Date.valueOf(paramTanggal)); // Konversi LocalDate ke java.sql.Date
            perintah.setString(3, paramMaterial);
            perintah.setInt(4, paramQty); // Mengubah dari setDouble ke setInt karena paramQty adalah int
            perintah.setString(5, paramType);
            perintah.setString(6, paramPit);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    //  Implementasi code untuk Tambah Data pada Table company
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
    
    //  Implementasi code untuk Tambah Data pada Table location
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

 //  Implementasi code untuk Tambah Data pada Table material
    public void simpanMaterial(String paramCodeMat, String paramDescMat, String paramComMat, LocalDate paramCreate) {
        try {
            String SQL = "INSERT INTO material (code_material, desc_material, comp_material, created_at) VALUES(?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramCodeMat);
            perintah.setString(2, paramDescMat);
            perintah.setString(3, paramComMat);
            perintah.setDate(4, Date.valueOf(paramCreate)); 
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //  Implementasi code untuk Update Data pada Table coal_getting
    public void updateCoal(int paramId, LocalDate paramTanggal, String paramMaterial, int paramQty, String paramType, String paramPit) {
        try {
            String SQL = "UPDATE coal_getting SET date =?, material=?, qty=?, type=?, pit=? WHERE id=?";
            
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setDate(1, Date.valueOf(paramTanggal)); // Konversi LocalDate ke java.sql.Date
            perintah.setString(2, paramMaterial);
            perintah.setInt(3, paramQty); // Mengubah dari setDouble ke setInt karena paramQty adalah int
            perintah.setString(4, paramType);
            perintah.setString(5, paramPit);
            perintah.setInt(6, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    //  Implementasi code untuk Update Data pada Table company
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
    
        //  Implementasi code untuk Update Data pada Table location
    public void updateLocation(String paramCodeLoc, String paramDescLoc, LocalDate paramCreate) {
        try {
            String SQL = "UPDATE location SET desc_location =?, created_at=? WHERE code_location=?";
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
    
    //  Implementasi code untuk Update Data pada Table material
    public void updateMaterial(String paramCodeMat, String paramDescMat, String paramComMat, LocalDate paramCreate) {
        try {
            String SQL = "UPDATE material SET desc_material =?, comp_material =?, created_at=? WHERE code_material=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramDescMat);
            perintah.setString(2, paramComMat);
            perintah.setDate(3, Date.valueOf(paramCreate));
            perintah.setString(4, paramCodeMat);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //  Implementasi code untuk Hapus Data pada Table getting_coal
    public void hapusCoal(int paramId) {
        try {
            String SQL = "DELETE FROM coal_getting WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId); // Mengubah dari setString ke setInt karena paramId adalah int
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }    

    //  Method untuk Hapus Data pada Table company
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
    
    //  Implementasi code untuk Hapus Data pada Table location
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
    
   //  Implementasi code untuk Hapus Data pada Table material 
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
   
      //  Implementasi code untuk Mencari Data berdasarkan Primary key yg akan menampilkan satu Baris/Record dari PK itu
      //  pada Table coal_getting 
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
      
      
      //  Implementasi code untuk Mencari Data berdasarkan Primary key yg akan menampilkan satu Baris/Record dari PK itu
      //  pada Table company 
      public void cariCompany(String paramId){
          try {
              String SQL = "SELECT * FROM company WHERE id=?";
              PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
              perintah.setString(1, paramId);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("id :"+data.getString("id"));
                  System.out.println("code_company :"+data.getString("code_company"));
                  System.out.println("desc_company :"+data.getString("desc_company"));
                  System.out.println("created_at :"+data.getString("created_at"));

              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      
      //  Implementasi code untuk Mencari Data berdasarkan Primary key yg akan menampilkan satu Baris/Record dari PK itu
      //  pada Table location
      public void cariLocation(String paramCodeLoc){
          try {
              String SQL = "SELECT * FROM location WHERE code_location=?";
              PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
              perintah.setString(1, paramCodeLoc);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("code_location :"+data.getString("code_location"));
                  System.out.println("desc_location :"+data.getString("desc_location"));
                  System.out.println("created_at :"+data.getString("created_at"));

              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      //  Implementasi code untuk Mencari Data berdasarkan Primary key yg akan menampilkan satu Baris/Record dari PK itu
      //  pada Table material
      public void cariMaterial(String paramCodeLoc){
          try {
              String SQL = "SELECT * FROM material WHERE code_material=?";
              PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
              perintah.setString(1, paramCodeLoc);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("code_material :"+data.getString("code_material"));
                  System.out.println("desc_material :"+data.getString("desc_material"));
                  System.out.println("created_at :"+data.getString("created_at"));

              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      
      //  Implementasi code untuk Mencari Keseluruhan Data pada Tabel coal_getting
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
      
      //  Implementasi code untuk Mencari Keseluruhan Data pada Tabel company
      public void dataCompany(){
          try {
              Statement stmt = KoneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("SELECT * FROM company ORDER BY id ASC");
              while (baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("code_company")+" | "+
                          baris.getString("desc_company")+" | "+
                          baris.getString("created_at"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
              
          }
          }
      
      
//  Implementasi code untuk Mencari Keseluruhan Data pada Tabel location
      public void dataLocation(){
          try {
              Statement stmt = KoneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("SELECT * FROM location ORDER BY code_location ASC");
              while (baris.next()){
                  System.out.println(baris.getString("code_location")+" | "+
                          baris.getString("desc_location")+" | "+
                          baris.getString("created_at"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
              
          }
          }
      
      //  Implementasi code untuk Mencari Keseluruhan Data pada Tabel material
      public void dataMaterial(){
          try {
              Statement stmt = KoneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("SELECT * FROM material ORDER BY code_material ASC");
              while (baris.next()){
                  System.out.println(baris.getString("code_material")+" | "+
                          baris.getString("desc_material")+" | "+
                          baris.getString("created_at"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
              
          }
          }
}


