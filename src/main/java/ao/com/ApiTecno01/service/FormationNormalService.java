package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.FormationNormal;
import ao.com.ApiTecno01.repository.FormationNormalRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class FormationNormalService {

    @Autowired
    private final FormationNormalRepository formationRepository;

    //LISTAR
    public List<FormationNormal> getAllFormationNormal() {
        return formationRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public FormationNormal getPorCodigo(long codigo) {
        return formationRepository.findById(codigo);
    }

    //CRIAR
    public FormationNormal createFormationNormal(FormationNormal formation, MultipartFile file) {
        return formationRepository.save(formation);
    }

    //ACTUALIZAR
    public FormationNormal updateFormationNormal(FormationNormal formation) {
        return formationRepository.save(formation);
    }

    //ELIMINAR
    public void deleteFormationNormal(long codigo) {
        formationRepository.deleteById(codigo);
    }
}
