package tambang_class;
import java.util.Date;

public class coal_getting {
     int id;
     String material, type, pit;
     Date date;
     int qty;
     
     // Contructor
     public coal_getting(int id, Date date, String material, int qty, String type, String pit) {
        this.id = id;
        this.date = date;
        this.material = material;
        this.qty = qty;
        this.type = type;
        this.pit = pit;
    }
    
     
    // Setter
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setPit(String pit) {
        this.pit = pit;
    }
    
    
    // Getter
    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMaterial() {
        return this.material;
    }

    public int getQty() {
        return this.qty;
    }

    public String getType() {
        return this.type;
    }

    public String getPit() {
        return this.pit;
    }
    
    @Override
    public String toString() {
        return "CoalGetting{" +
                "id=" + id +
                ", date=" + date +
                ", material='" + material + '\'' +
                ", qty=" + qty +
                ", type='" + type + '\'' +
                ", pit='" + pit + '\'' +
                '}';
    }

}
