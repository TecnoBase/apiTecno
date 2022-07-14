package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
    Evento findById(long codigo);
}
