/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_tambang_2210010111;
import tambang_model.*; // mengimport semua class pada package tambang_model 
import java.util.ArrayList; // Menambahkan, menghapus, dan mengakses elemen dengan mudah.
import Koneksi.Database; // mengimport class Database pada package Koneksi
import java.time.LocalDate; // Mendapatkan tanggal saat ini, menambah/mengurangi hari/bulan/tahun, dan mengubah format tanggal.

/**
 *
 * @author User
 */
public class Project_tambang_2210010111 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database db = new Database(); // Method untuk mengecek apakah sudah konek ke db
        
        // Mendapatkan tanggal saat ini
        LocalDate today = LocalDate.now();
//        System.out.println(today); // Output: (tanggal hari ini)

        // Membuat objek LocalDate untuk tanggal 21 Maret 2025 (dari nilai spesifik)
        LocalDate date = LocalDate.of(2025, 3, 21);
        
        // Parsing string ke LocalDate
        LocalDate parsedDate = LocalDate.parse("2024-06-06");
        
    //  Method untuk Simpan, update, dan Hapus Data pada Table coal_getting 
//      CRUD tb coal_getting
//        db.simpanCoal(6, date, "Besi", 12, "Karat", "West Pit");
//        db.updateCoal(6, date, "Belerang", 9, "Berbau", "North Pit");
//        db.hapusCoal(5);

   //  Method untuk Simpan, update, dan Hapus Data pada Table company 
//      CRUD tb company
//        db.simpanCompany(4, "CODE 1", "NGGAK TAU DESKRIPSI", date);
//        db.updateCompany(4, "CODE 2", "YO NGGK TAU 2", date);
//        db.hapusCompany(4);

   //  Method untuk Simpan, update, dan Hapus Data pada Table location 
//      CRUD tb location
//          db.simpanLocation("LOC004", "KALIMANTAN UTARA", date);
//          db.updateLocation("LOC004", "KALIMANTAN TIMUR", date);
//          db.hapusLocation("LOC004");


   //  Method untuk Simpan, update, dan Hapus Data pada Table material 
//      CRUD tb material
//          db.simpanMaterial("MAT006", "Berlian", "Perusahaan Fiktif", date);
//          db.updateMaterial("MAT006", "BERLIAN 2", "Perusahaan Fiktif 2", date);
//          db.hapusMaterial("MAT006");

//    PK DATA DISPLAY
//    Method untuk mengambil data (PK) berdasarkan Primary key pada table coal_getting
//      db.cariCoal("3");
      
//    Method untuk mengambil data (PK) berdasarkan Primary key pada table company
//      db.cariCompany("3");

//    Method untuk mengambil data (PK) berdasarkan Primary key pada table location
//      db.cariLocation("LOC001");

//    Method untuk mengambil data (PK) berdasarkan Primary key pada table material
//      db.cariMaterial("MAT001");
      

//    ALL DATA DISPLAY
//    Method untuk mengambil data (ALL) secara keseluruhan pada table coal_getting
//      db.dataCoal();

//    Method untuk mengambil data (ALL) secara keseluruhan pada table company
//      db.dataCompany();

//    Method untuk mengambil data (ALL) secara keseluruhan pada table location
//      db.dataLocation();

//    Method untuk mengambil data (ALL) secara keseluruhan pada table location
//      db.dataMaterial();
    }
    
    
    
}
