
package bike;

public class BikeRented extends AbstractEvent {

    private Long id;
    private Long bikeInventoryId;
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBikeInventoryId() {
        return bikeInventoryId;
    }

    public void setBikeInventoryId(Long bikeInventoryId) {
        this.bikeInventoryId = bikeInventoryId;
    }
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}