package spring.demo.endPoint;

import com.example.me.GetBundleRequest;
import com.example.me.GetBundleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import spring.demo.service.BundleService;

import static spring.demo.config.Constants.SOAP_NAMESPACE;
import static spring.demo.config.Constants.WSDL_BEAN_NAME;


@Endpoint
public class BundleEndPoint {

    @Autowired
    private BundleService service;

    @PayloadRoot(namespace = SOAP_NAMESPACE, localPart = "getBundleRequest")
    @ResponsePayload
    public GetBundleResponse getBundle(@RequestPayload GetBundleRequest request) {
        GetBundleResponse response = new GetBundleResponse();
        BundleService service = new BundleService();
        response.setBundle(service.checkBundle(request.getId()));
        return response;
    }

}