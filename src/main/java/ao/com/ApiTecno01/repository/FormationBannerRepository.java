package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.FormationBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationBannerRepository extends JpaRepository<FormationBanner, Long> {

    FormationBanner findById(long codigo);
}
