package cardealershop.controller;

import cardealershop.model.VinModel;
import cardealershop.service.VinModelService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VinModelRestController {

    private VinModelService vinModelService;

    public VinModelRestController(VinModelService vinModelService) {
        this.vinModelService = vinModelService;
    }
    // no mapping since ApiKey is not valid (I did not provide my credit card crudentials :)
    @GetMapping("/api/vin")
    public VinModel getVinData(@RequestParam String vin){
        return vinModelService.getVinData(vin);
    }
}
