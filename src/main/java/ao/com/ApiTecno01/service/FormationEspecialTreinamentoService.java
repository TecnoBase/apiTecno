package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.FormationEspecialTreinamento;
import ao.com.ApiTecno01.repository.FormationEspecialTreinamentoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class FormationEspecialTreinamentoService {
    
@Autowired
    private final FormationEspecialTreinamentoRepository formationEspecialTreinamentoRepository;

    //LISTAR
    public List<FormationEspecialTreinamento> getAllFormationEspecialTreinamento() {
        return formationEspecialTreinamentoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public FormationEspecialTreinamento getPorCodigo(long codigo) {
        return formationEspecialTreinamentoRepository.findById(codigo);
    }

    //CRIAR
    public FormationEspecialTreinamento createFormation(FormationEspecialTreinamento formation, MultipartFile file) {
        return formationEspecialTreinamentoRepository.save(formation);
    }

    //ACTUALIZAR
    public FormationEspecialTreinamento updateFormationEspecialTreinamento(FormationEspecialTreinamento formation) {
        return formationEspecialTreinamentoRepository.save(formation);
    }

    //ELIMINAR
    public void deleteFormationEspecialTreinamento(long codigo) {
        formationEspecialTreinamentoRepository.deleteById(codigo);
    }
}

