package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.FormationBanner;
import ao.com.ApiTecno01.repository.FormationBannerRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FormationBannerService {

    @Autowired
    private final FormationBannerRepository formationBannerRepository;

    public List<FormationBanner> listarFormationBanner() {
        List<FormationBanner> formationBanner = new ArrayList<>();
        formationBannerRepository.findAll().forEach(formationBanner::add);
        return formationBanner;
    }

    //BUSCAR POR CODIGO
    public FormationBanner getPorCodigo(long codigo) {
        return formationBannerRepository.findById(codigo);
    }

    //CRIAR
    public FormationBanner createFormationBanner(FormationBanner formationBanner) {
        return formationBannerRepository.save(formationBanner);
    }

    //ACTUALIZAR
    public FormationBanner updateFormationBanner(FormationBanner formationBanner) {
        return formationBannerRepository.save(formationBanner);
    }

    //ELIMINAR
    public void deleteFormationBanner(long codigo) {
        formationBannerRepository.deleteById(codigo);
    }

}
