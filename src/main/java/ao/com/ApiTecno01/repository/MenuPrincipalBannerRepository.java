package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.MenuPrincipalBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPrincipalBannerRepository extends JpaRepository<MenuPrincipalBanner, Long> {

    MenuPrincipalBanner findById(long codigo);
}
