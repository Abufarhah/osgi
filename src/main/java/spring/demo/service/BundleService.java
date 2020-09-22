package spring.demo.service;

import com.example.me.Bundle;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    public Bundle checkBundle(int id) {
        Bundle acknowledgement = new Bundle();

        acknowledgement.setId(id);
        acknowledgement.setName("test");
        acknowledgement.setPrice(10);

        return acknowledgement;

    }

}