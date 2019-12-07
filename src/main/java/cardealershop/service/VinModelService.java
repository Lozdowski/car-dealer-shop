package cardealershop.service;

import cardealershop.model.VinModel;
import cardealershop.repository.VinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VinModelService {

    @Autowired
    VinModelRepository vinModelRepository;

    // no mapping since ApiKey is not valid (I did not provide my credit card crudentials :)
    public ResponseEntity<VinModel> getVinData(String vin){
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "vindecoder.p.rapidapi.com");
        headers.set("x-rapidapi-key", "c7a58c80e2msheeb85f4006cc12cp158c12jsn5d968db46215");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<VinModel> response= restTemplate.exchange("https://vindecoder.p.rapidapi.com/decode_vin?vin="+vin, HttpMethod.GET,httpEntity,VinModel.class);
        return response;
    }
    public void saveVin(VinModel vinModel){
        vinModelRepository.save(vinModel);
    }
}
