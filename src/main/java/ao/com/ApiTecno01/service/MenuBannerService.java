package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.MenuBanner;
import ao.com.ApiTecno01.repository.MenuBannerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class MenuBannerService {
    

 @Autowired
    private final MenuBannerRepository menuBannerRepository;

     //LISTAR
    public List<MenuBanner> getAllMenuBanner() {
        return menuBannerRepository.findAll();
    }
    
    //BUSCAR POR CODIGO
    public MenuBanner getPorCodigo(long codigo) {
        return menuBannerRepository.findById(codigo);
    }

    //CRIAR
    public MenuBanner createMenuBanner(MenuBanner menuBanner, MultipartFile file) {
        return menuBannerRepository.save(menuBanner);
    }

    //ACTUALIZAR
  public MenuBanner updateMenuBanner(MenuBanner menuBanner) {
        return menuBannerRepository.save(menuBanner);
    }

    //ELIMINAR
    public void deleteMenuBanner(long codigo) {
        menuBannerRepository.deleteById(codigo);
    }
}

