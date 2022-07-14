package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.MenuSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuSiteRepository extends JpaRepository<MenuSite, Long> {

    MenuSite findById(long codigo);
}

