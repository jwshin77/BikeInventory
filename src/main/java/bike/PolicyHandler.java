package bike;

import bike.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    BikeInventoryRepository bikeInventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBikeReturned_UpdateBikeStatus(@Payload BikeReturned bikeReturned){

        if(bikeReturned.isMe()){
            System.out.println("##### listener UpdateBikeStatus : " + bikeReturned.toJson());

            bikeInventoryRepository.findById(bikeReturned.getBikeInventoryId())
                    .ifPresent(
                            bikeInventory ->{
                                bikeInventory.setLocation(bikeReturned.getLocation());
                                bikeInventory.setStatus(bikeReturned.getStatus());
                                bikeInventoryRepository.save(bikeInventory);
                            }
                    );
            //bikeInventoryRepository.findByBikeInventoryId(bikeReturned.getBikeInventoryId());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBikeRented_UpdateBikeStatus(@Payload BikeRented bikeRented){

        if(bikeRented.isMe()){
            System.out.println("##### listener UpdateBikeStatus : " + bikeRented.toJson());

            bikeInventoryRepository.findById(bikeRented.getBikeInventoryId())
                    .ifPresent(
                            bikeInventory ->{
                                bikeInventory.setLocation("-");
                                bikeInventory.setStatus(bikeRented.getStatus());

                                bikeInventoryRepository.save(bikeInventory);
                            }
                    );
            //BikeInventory bikeInventory = bikeInventoryRepository.findByBikeInventoryId(bikeRented.getBikeInventoryId());
        }
    }

}
