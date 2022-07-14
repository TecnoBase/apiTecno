package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.MenuPrincipalBanner;
import ao.com.ApiTecno01.service.MenuPrincipalBannerService;
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
public class MenuPrincipalBannerController {
    
@Autowired
    private final MenuPrincipalBannerService menuPrincipalBannerService;

    //http://localhost:8080/api/menuPrincipalBanners
    @GetMapping("/menuPrincipalBanners")
    public List<MenuPrincipalBanner> getAllMenuPrincipalBanner() {
        return menuPrincipalBannerService.listarMenuPrincipalBanner();
    }

//    http://localhost:8080/api/menuPrincipalBanner/1
    @GetMapping("/menuPrincipalBanner/{codigo}")
    public MenuPrincipalBanner getPorCodigo(@PathVariable Long codigo) {
        return menuPrincipalBannerService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/menuPrincipalBanner
    @PostMapping("/menuPrincipalBanner")
    public MenuPrincipalBanner createMenuPrincipalBanner(@RequestBody MenuPrincipalBanner menuPrincipalBanner) {
        return menuPrincipalBannerService.createMenuPrincipalBanner(menuPrincipalBanner);
    }

    //http://localhost:8080/api/menuPrincipalBanner
    @PutMapping("/menuPrincipalBanner")
    public MenuPrincipalBanner updateMenuPrincipalBanner(@RequestBody MenuPrincipalBanner menuPrincipalBanner) {
        return menuPrincipalBannerService.updateMenuPrincipalBanner(menuPrincipalBanner);
    }

    //http://localhost:8080/api/menuPrincipalBanner/1 
    @DeleteMapping("/menuPrincipalBanner/{codigo}")
    public void deleteMenuPrincipalBanner(@PathVariable(value = "codigo") long codigo) {
        menuPrincipalBannerService.deleteMenuPrincipalBanner(codigo);
    }

}


