package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.MenuBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuBannerRepository extends JpaRepository<MenuBanner, Long> {

    MenuBanner findById(long codigo);
}
