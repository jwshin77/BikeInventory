package bike;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="BikeInventory_table")
public class BikeInventory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long status;
    private String location;

    @PostPersist
    public void onPostPersist(){
        BikeRegisted bikeRegisted = new BikeRegisted();
        BeanUtils.copyProperties(this, bikeRegisted);
        bikeRegisted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        BikeRelocated bikeRelocated = new BikeRelocated();
        BeanUtils.copyProperties(this, bikeRelocated);
        bikeRelocated.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




}
