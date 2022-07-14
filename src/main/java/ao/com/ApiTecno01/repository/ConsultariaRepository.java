package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Consultaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultariaRepository extends JpaRepository<Consultaria, Long>{
    Consultaria findById(long codigo);
}
