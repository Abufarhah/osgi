package spring.demo.service;

import com.example.me.Bundle;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    public Bundle checkBundle(Bundle request) {
        Bundle acknowledgement = new Bundle();

        request.getId();
        acknowledgement.setId(request.getId());
        acknowledgement.setName("test");
        acknowledgement.setPrice(10);

        return acknowledgement;

    }

}