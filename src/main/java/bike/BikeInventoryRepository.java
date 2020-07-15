package bike;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BikeInventoryRepository extends PagingAndSortingRepository<BikeInventory, Long>{


}