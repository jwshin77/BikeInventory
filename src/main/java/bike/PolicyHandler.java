package bike;

import bike.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBikeReturned_UpdateBikeStatus(@Payload BikeReturned bikeReturned){

        if(bikeReturned.isMe()){
            System.out.println("##### listener UpdateBikeStatus : " + bikeReturned.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBikeRented_UpdateBikeStatus(@Payload BikeRented bikeRented){

        if(bikeRented.isMe()){
            System.out.println("##### listener UpdateBikeStatus : " + bikeRented.toJson());
        }
    }

}
