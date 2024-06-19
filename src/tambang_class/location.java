package tambang_class;
import java.util.Date;

public class location {
    String codeLocation, descLocation;
    Date createdAt;

    public location(String codeLocation, String descLocation, Date createdAt) {
        this.codeLocation = codeLocation;
        this.descLocation = descLocation;
        this.createdAt = createdAt;
    }
   
    
    // Setter
    public void setCodeLocation(String codeLocation) {
        this.codeLocation = codeLocation;
    }

    public void setDescLocation(String descLocation) {
        this.descLocation = descLocation;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
    // Getter
    public String getCodeLocation() {
        return this.codeLocation;
    }

    public String getDescLocation() {
        return this.descLocation;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
}
