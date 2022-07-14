package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.InscricoesExternasTreinamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricoesExternasTreinamentoRepository extends JpaRepository<InscricoesExternasTreinamento, Long> {

    InscricoesExternasTreinamento findById(long codigo);
}
