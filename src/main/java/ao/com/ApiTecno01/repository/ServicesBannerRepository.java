package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.ServicesBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesBannerRepository extends JpaRepository<ServicesBanner, Long>{
    
    ServicesBanner findById(long codigo);
    
}
