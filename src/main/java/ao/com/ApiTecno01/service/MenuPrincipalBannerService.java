package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.MenuPrincipalBanner;
import ao.com.ApiTecno01.repository.MenuPrincipalBannerRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MenuPrincipalBannerService {

    @Autowired
    private final MenuPrincipalBannerRepository menuPrincipalBannerRepository;

    public List<MenuPrincipalBanner> listarMenuPrincipalBanner() {
        List<MenuPrincipalBanner> menuPrincipalBanner = new ArrayList<>();
        menuPrincipalBannerRepository.findAll().forEach(menuPrincipalBanner::add);
        return menuPrincipalBanner;
    }

    //BUSCAR POR CODIGO
    public MenuPrincipalBanner getPorCodigo(long codigo) {
        return menuPrincipalBannerRepository.findById(codigo);
    }

    //CRIAR
    public MenuPrincipalBanner createMenuPrincipalBanner(MenuPrincipalBanner menuPrincipalBanner) {
        return menuPrincipalBannerRepository.save(menuPrincipalBanner);
    }

    //ACTUALIZAR
    public MenuPrincipalBanner updateMenuPrincipalBanner(MenuPrincipalBanner menuPrincipalBanner) {
        return menuPrincipalBannerRepository.save(menuPrincipalBanner);
    }

    //ELIMINAR
    public void deleteMenuPrincipalBanner(long codigo) {
        menuPrincipalBannerRepository.deleteById(codigo);
    }

}
