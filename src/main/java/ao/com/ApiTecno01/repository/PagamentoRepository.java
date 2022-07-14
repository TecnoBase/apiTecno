package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Pagamento findById(long codigo);
}
