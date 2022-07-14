package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.MenuSite;
import ao.com.ApiTecno01.service.MenuSiteService;
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
public class MenuSiteController {
    
@Autowired
    private final MenuSiteService menuSiteService;

    //http://localhost:8080/api/menuSites
    @GetMapping("/menuSites")
    public List<MenuSite> getAllMenuSite() {
        return menuSiteService.listarMenuSite();
    }

//    http://localhost:8080/api/menuSite/1
    @GetMapping("/menuSite/{codigo}")
    public MenuSite getPorCodigo(@PathVariable Long codigo) {
        return menuSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/menuSite
    @PostMapping("/menuSite")
    public MenuSite createMenuSite(@RequestBody MenuSite menuSite) {
        return menuSiteService.createMenuSite(menuSite);
    }

    //http://localhost:8080/api/menuSite
    @PutMapping("/menuSite")
    public MenuSite updateMenuSite(@RequestBody MenuSite menuSite) {
        return menuSiteService.updateMenuSite(menuSite);
    }

    //http://localhost:8080/api/menuSite/1 
    @DeleteMapping("/menuSite/{codigo}")
    public void deleteMenuSite(@PathVariable(value = "codigo") long codigo) {
        menuSiteService.deleteMenuSite(codigo);
    }

}



