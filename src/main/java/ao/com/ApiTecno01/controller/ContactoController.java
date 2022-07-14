package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Contacto;
import ao.com.ApiTecno01.service.ContactoService;
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
public class ContactoController {

    @Autowired
    private final ContactoService contactoSiteService;

    //http://localhost:8080/api/contactoSites
    @GetMapping("/contactoSites")
    public List<Contacto> getAllContacto() {
        return contactoSiteService.getAllContacto();
    }

    //http://localhost:8080/api/contactoSite/1
    @GetMapping("/contactoSite/{codigo}")
    public Contacto getPorCodigo(@PathVariable Long codigo) {
        return contactoSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/contactoSite
    @PostMapping("/contactoSite")
    public Contacto createContacto(@RequestBody Contacto contactoSite) {
        return contactoSiteService.createContacto(contactoSite);
    }

    //http://localhost:8080/api/contactoSite
    @PutMapping("/contactoSite")
    public Contacto updateContacto(@RequestBody Contacto contactoSite) {
        return contactoSiteService.updateContacto(contactoSite);
    }

    //http://localhost:8080/api/contactoSite/1 
    @DeleteMapping("/contactoSite/{codigo}")
    public void deleteContacto(@PathVariable(value = "codigo") long codigo) {
        contactoSiteService.deleteContacto(codigo);
    }

}
