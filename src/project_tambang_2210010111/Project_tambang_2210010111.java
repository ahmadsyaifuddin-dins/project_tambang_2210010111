package project_tambang_2210010111;

import Koneksi.Database; // Import kelas Database
import tambang_class.*; // Import semua class di package tambang_class
import java.time.LocalDate; // Mendapatkan tanggal saat ini, menambah/mengurangi hari/bulan/tahun, dan mengubah format tanggal.
import gui.frameUtama;

public class Project_tambang_2210010111 {
    public static void main(String[] args) {
        
        Database db = new Database();
          
        LocalDate today = LocalDate.now();
        System.out.println(today); // Output: (tanggal hari ini)

        new frameUtama().setVisible(true);

    }
}









// Mendapatkan tanggal saat ini
//        LocalDate today = LocalDate.now();
//        System.out.println(today); // Output: (tanggal hari ini)
//
//        // Membuat objek LocalDate untuk tanggal 21 Maret 2025 (dari nilai spesifik)
//        LocalDate date = LocalDate.of(2025, 3, 21);
//
//        // Parsing string ke LocalDate
//        LocalDate parsedDate = LocalDate.parse("2024-06-06");
//
//        // Inisialisasi koneksi database
//        Database db = new Database();
        

        // Buat objek dari kelas coal_getting dengan koneksi database
//        coal_getting coalDb = new coal_getting(db.KoneksiDB);

        // Method untuk Simpan, update, dan Hapus Data pada Table coal_getting 
        // CRUD tb coal_getting
//        db.simpanCoal(7, today, "Uranium", 60, "Radioaktif Tinggi", "North Pit");
//        coalDb.updateCoal(7, today, "Belerang", 9, "Berbau", "North Pit");
//        coalDb.hapusCoal(7);

        // Method untuk mengambil data (PK) berdasarkan Primary key pada table coal_getting
//        db.cariCoal("3");

        // Method untuk mengambil data (ALL) secara keseluruhan pada table coal_getting
//        db.dataCoal();

        // Buat objek dari kelas company dengan koneksi database
//        company companyDb = new company(db.KoneksiDB);

        // Method untuk Simpan, update, dan Hapus Data pada Table company 
        // CRUD tb company
//        companyDb.simpanCompany(4, "CODE 1", "NGGAK TAU DESKRIPSI", date);
//        companyDb.updateCompany(4, "CODE 2", "YO NGGK TAU 2", date);
//        companyDb.hapusCompany(4);

        // Method untuk mengambil data (PK) berdasarkan Primary key pada table company
//        companyDb.cariCompany("3");

        // Method untuk mengambil data (ALL) secara keseluruhan pada table company
//        companyDb.dataCompany();

        // Buat objek dari kelas location dengan koneksi database
//        location locationDb = new location(db.KoneksiDB);

        // Method untuk Simpan, update, dan Hapus Data pada Table location 
        // CRUD tb location
//        locationDb.simpanLocation("LOC004", "KALIMANTAN UTARA", date);
//        locationDb.updateLocation("LOC004", "KALIMANTAN TIMUR", date);
//        locationDb.hapusLocation("LOC004");

        // Method untuk mengambil data (PK) berdasarkan Primary key pada table location
//        locationDb.cariLocation("LOC001");

        // Method untuk mengambil data (ALL) secara keseluruhan pada table location
//        locationDb.dataLocation();

        // Buat objek dari kelas material dengan koneksi database
//        material materialDb = new material(db.KoneksiDB);

        // Method untuk Simpan, update, dan Hapus Data pada Table material 
        // CRUD tb material
//        materialDb.simpanMaterial("MAT006", "Berlian", "Perusahaan Fiktif", date);
//        materialDb.updateMaterial("MAT006", "BERLIAN 2", "Perusahaan Fiktif 2", date);
//        materialDb.hapusMaterial("MAT006");

        // Method untuk mengambil data (PK) berdasarkan Primary key pada table material
//        materialDb.cariMaterial("MAT001");

        // Method untuk mengambil data (ALL) secara keseluruhan pada table material
//        materialDb.dataMaterial();