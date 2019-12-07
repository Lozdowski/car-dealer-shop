package cardealershop.controller;

import cardealershop.model.VinModel;

import cardealershop.service.VinModelService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class VinModelController {

    private VinModelService vinModelService;

    public VinModelController(VinModelService vinModelService) {
        this.vinModelService = vinModelService;
    }
    // no mapping since ApiKey is not valid (I did not provide my credit card crudentials :)
    @GetMapping("/vin")
    public ResponseEntity<VinModel> getVinData(@RequestParam String vin, ModelMap model){
       return  vinModelService.getVinData(vin);

    }



}
