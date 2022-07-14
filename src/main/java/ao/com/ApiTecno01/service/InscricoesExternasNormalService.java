package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.FormationEspecialTreinamento;
import ao.com.ApiTecno01.models.InscricoesExternasNormal;
import ao.com.ApiTecno01.repository.FormationEspecialTreinamentoRepository;
import ao.com.ApiTecno01.repository.InscricoesExternasNormalRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class InscricoesExternasNormalService {
    
  
@Autowired
    private final InscricoesExternasNormalRepository inscricoesExternasNormalRepository;

    //LISTAR
    public List<InscricoesExternasNormal> getAllFormationEspecialTreinamento() {
        return inscricoesExternasNormalRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public InscricoesExternasNormal getPorCodigo(long codigo) {
        return inscricoesExternasNormalRepository.findById(codigo);
    }

    //CRIAR
    public InscricoesExternasNormal createFormation(InscricoesExternasNormal formation) {
        return inscricoesExternasNormalRepository.save(formation);
    }

    //ACTUALIZAR
    public InscricoesExternasNormal updateFormationEspecialTreinamento(InscricoesExternasNormal formation) {
        return inscricoesExternasNormalRepository.save(formation);
    }

    //ELIMINAR
    public void deleteInscricoesExternasNormal(long codigo) {
        inscricoesExternasNormalRepository.deleteById(codigo);
    }
}

