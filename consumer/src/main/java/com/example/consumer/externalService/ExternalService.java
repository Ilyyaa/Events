package com.example.consumer.externalService;

import com.example.consumer.domain.Order;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalService {
    public void call(Order order) throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if(randomInt <= 4){
            throw new Exception("Service down");
        }
    }
}
