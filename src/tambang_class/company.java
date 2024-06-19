package tambang_class;
import java.util.Date;


public class company {
     int id;
     String codeCompany, descCompany;
     Date createdAt;
    
    // Contructor
    public company(int id, String codeCompany, String descCompany, Date createdAt) {
        this.id = id;
        this.codeCompany = codeCompany;
        this.descCompany = descCompany;
        this.createdAt = createdAt;
    }
    
    // Setter
     public void setId(int id) {
        this.id = id;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public void setDescCompany(String descCompany) {
        this.descCompany = descCompany;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
    // Getter
    public int getId() {
        return this.id;
    }

    public String getCodeCompany() {
        return this.codeCompany;
    }
    

    public String getDescCompany() {
        return this.descCompany;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    
    
}
