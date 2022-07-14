package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.InscricoesExternasTreinamento;
import ao.com.ApiTecno01.repository.InscricoesExternasTreinamentoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InscricoesExternasTreinamentoService {

    @Autowired
    private final InscricoesExternasTreinamentoRepository inscricoesExternasTreinamentoRepository;

    //LISTAR
    public List<InscricoesExternasTreinamento> getAllFormationEspecialTreinamento() {
        return inscricoesExternasTreinamentoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public InscricoesExternasTreinamento getPorCodigo(long codigo) {
        return inscricoesExternasTreinamentoRepository.findById(codigo);
    }

    //CRIAR
    public InscricoesExternasTreinamento createFormation(InscricoesExternasTreinamento formation) {
        return inscricoesExternasTreinamentoRepository.save(formation);
    }

    //ACTUALIZAR
    public InscricoesExternasTreinamento updateFormationEspecialTreinamento(InscricoesExternasTreinamento formation) {
        return inscricoesExternasTreinamentoRepository.save(formation);
    }

    //ELIMINAR
    public void deleteFormationEspecialTreinamento(long codigo) {
        inscricoesExternasTreinamentoRepository.deleteById(codigo);
    }
}
