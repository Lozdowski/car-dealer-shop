package cardealershop.controller;

import cardealershop.model.VinModel;
import cardealershop.service.VinModelService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VinModelController {
    private VinModelService vinModelService;

    public VinModelController(VinModelService vinModelService) {
        this.vinModelService = vinModelService;
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/vin")
    public String inputVinNumber(){
        return "vinForm";
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/vin/checker")
    public String vinChecker(@RequestParam String vin, ModelMap modelMap){
        VinModel vinModel = vinModelService.getVinData(vin);
        modelMap.put("vinmodel",vinModel);
        return "vin";
    }
}
