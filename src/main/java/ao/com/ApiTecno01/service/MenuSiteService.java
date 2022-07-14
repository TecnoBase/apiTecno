package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.MenuSite;
import ao.com.ApiTecno01.repository.MenuSiteRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MenuSiteService {
    
 @Autowired
    private final MenuSiteRepository menuSiteRepository;

    public List<MenuSite> listarMenuSite() {
//        return menuSiteRepository.findAll();
        List<MenuSite> menuSite = new ArrayList<>();
        menuSiteRepository.findAll().forEach(menuSite::add);
        return menuSite;
    }

    //BUSCAR POR CODIGO
    public MenuSite getPorCodigo(long codigo) {
        return menuSiteRepository.findById(codigo);
    }

    //CRIAR
    public MenuSite createMenuSite(MenuSite menuSite) {
        return menuSiteRepository.save(menuSite);
    }

    //ACTUALIZAR
    public MenuSite updateMenuSite(MenuSite menuSite) {
        return menuSiteRepository.save(menuSite);
    }

    //ELIMINAR
    public void deleteMenuSite(long codigo) {
        menuSiteRepository.deleteById(codigo);
    }

}



