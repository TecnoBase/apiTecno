package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{
    
    Contacto findById(long codigo);
}
