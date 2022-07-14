package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long>{
    Newsletter findById(long codigo);
}
