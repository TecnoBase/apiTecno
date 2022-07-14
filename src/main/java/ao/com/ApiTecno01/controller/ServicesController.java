package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Services;
import ao.com.ApiTecno01.repository.ServicesRepository;
import ao.com.ApiTecno01.service.ServicesService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class ServicesController {

    @Autowired
    private final ServicesService servicesService;

    @Autowired
    private final ServicesRepository servicesRepository;

    //http://localhost:8080/api/servicess
    @GetMapping("/servicess")
    public List<Services> getAllServices() {
        return servicesService.listarServices();
    }

//    http://localhost:8080/api/services/1
    @GetMapping("/services/{codigo}")
    public Services getPorCodigo(@PathVariable Long codigo) {
        return servicesService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/services
    @PostMapping("/services")
    public Services createServices(@RequestBody Services services) {
        return servicesService.createServices(services);
    }

    //http://localhost:8080/api/services
    @PutMapping("/services")
    public Services updateServices(@RequestBody Services services) {
        return servicesService.updateServices(services);
    }

    //http://localhost:8080/api/services/1 
    @DeleteMapping("/services/{codigo}")
    public void deleteServices(@PathVariable(value = "codigo") long codigo) {
        servicesService.deleteServices(codigo);
    }

    //PESQUISAR POR TITULO
    //http://localhost:8080/api/pesquisarserivice
//    @PostMapping("**/pesquisarserivice")
//    public Services pesquisar(@RequestParam("title") String title) {
//        return (Services) servicesRepository.findPessoaByName(title);
//    }

}
