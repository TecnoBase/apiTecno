package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.ProjectInternBu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectInternBuRepository extends JpaRepository<ProjectInternBu, Long>{
    
    ProjectInternBu findById(long codigo);
}
