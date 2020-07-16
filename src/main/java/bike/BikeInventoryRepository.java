package bike;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BikeInventoryRepository extends PagingAndSortingRepository<BikeInventory, Long>{

    //List<BikeInventory> findByBikeInventoryId(Long id);
}