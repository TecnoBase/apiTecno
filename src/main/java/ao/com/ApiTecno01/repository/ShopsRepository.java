package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopsRepository extends JpaRepository<Shops, Long>{
    Shops findById(long codigo);   
}
