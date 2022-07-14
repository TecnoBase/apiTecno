package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.FormationBanner;
import ao.com.ApiTecno01.service.FormationBannerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class FormationBannerController {
    
@Autowired
    private final FormationBannerService formationBannerService;

    //http://localhost:8080/api/formationBanners
    @GetMapping("/formationBanners")
    public List<FormationBanner> getAllFormationBanner() {
        return formationBannerService.listarFormationBanner();
    }

//    http://localhost:8080/api/formationBanner/1
    @GetMapping("/formationBanner/{codigo}")
    public FormationBanner getPorCodigo(@PathVariable Long codigo) {
        return formationBannerService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/formationBanner
    @PostMapping("/formationBanner")
    public FormationBanner createFormationBanner(@RequestBody FormationBanner formationBanner) {
        return formationBannerService.createFormationBanner(formationBanner);
    }

    //http://localhost:8080/api/formationBanner
    @PutMapping("/formationBanner")
    public FormationBanner updateFormationBanner(@RequestBody FormationBanner formationBanner) {
        return formationBannerService.updateFormationBanner(formationBanner);
    }

    //http://localhost:8080/api/formationBanner/1 
    @DeleteMapping("/formationBanner/{codigo}")
    public void deleteFormationBanner(@PathVariable(value = "codigo") long codigo) {
        formationBannerService.deleteFormationBanner(codigo);
    }

}




