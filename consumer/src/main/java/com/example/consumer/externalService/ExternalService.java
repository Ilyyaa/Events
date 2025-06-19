package com.example.consumer.externalService;

import com.example.consumer.domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalService {
    public void call(Purchase purchase) throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt(2);
        if(randomInt == 1){
           throw new Exception("Service down");
        }
    }
}
