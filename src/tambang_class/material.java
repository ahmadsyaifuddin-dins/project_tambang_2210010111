package tambang_class;
import java.util.Date;

public class material {
    String codeMaterial, descMaterial, compMaterial;
    Date createdAt;
    
    public material(String codeMaterial, String descMaterial, String compMaterial, Date createdAt) {
        this.codeMaterial = codeMaterial;
        this.descMaterial = descMaterial;
        this.compMaterial = compMaterial;
        this.createdAt = createdAt;
    }

    
    // setter
    public void setCodeMaterial(String codeMaterial) {
        this.codeMaterial = codeMaterial;
    }
   

    public void setDescMaterial(String descMaterial) {
        this.descMaterial = descMaterial;
    }
    

    public void setCompMaterial(String compMaterial) {
        this.compMaterial = compMaterial;
    }
    

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
    // Getter
    public String getCodeMaterial() {
        return this.codeMaterial;
    }

    public String getDescMaterial() {
        return this.descMaterial;
    }

    public String getCompMaterial() {
        return this.compMaterial;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    
    
    
//    private Connection KoneksiDB;
//
//    // Konstruktor untuk menerima objek koneksi
//    public material(Connection KoneksiDB) {
//        this.KoneksiDB = KoneksiDB;
    
    }

    
