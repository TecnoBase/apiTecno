package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.InscricoesExternasNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricoesExternasNormalRepository extends JpaRepository<InscricoesExternasNormal, Long>{
    InscricoesExternasNormal findById(long codigo);
}
