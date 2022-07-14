package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.ServicesBanner;
import ao.com.ApiTecno01.repository.ServicesBannerRepository;
import ao.com.ApiTecno01.service.ServicesBannerService;
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
public class ServicesBannerController {

    @Autowired
    private final ServicesBannerService servicesBannerService;
    
    @Autowired
    private ServicesBannerRepository servicesBannerRepository;

    //http://localhost:8080/api/servicesBanners
    @GetMapping("/servicesBanners")
    public List<ServicesBanner> getAllServicesBanner() {
        return servicesBannerService.listarServices();
    }

//    http://localhost:8080/api/servicesBanner/1
    @GetMapping("/servicesBanner/{codigo}")
    public ServicesBanner getPorCodigo(@PathVariable Long codigo) {
        return servicesBannerService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/servicesBanner
    @PostMapping("/servicesBanner")
    public ServicesBanner createServicesBanner(@RequestBody ServicesBanner servicesBanner) {
        return servicesBannerService.createServices(servicesBanner);
    }

    //http://localhost:8080/api/servicesBanner
    @PutMapping("/servicesBanner")
    public ServicesBanner updateServicesBanner(@RequestBody ServicesBanner servicesBanner) {
        return servicesBannerService.updateServices(servicesBanner);
    }

    //http://localhost:8080/api/servicesBanner/1 
    @DeleteMapping("/servicesBanner/{codigo}")
    public void deleteServicesBanner(@PathVariable(value = "codigo") long codigo) {
        servicesBannerService.deleteServices(codigo);
    }

}
