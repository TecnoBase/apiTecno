package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.FormationEspecialTreinamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationEspecialTreinamentoRepository extends JpaRepository<FormationEspecialTreinamento, Long> {

    FormationEspecialTreinamento findById(long codigo);
}
