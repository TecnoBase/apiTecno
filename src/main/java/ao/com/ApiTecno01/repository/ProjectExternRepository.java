package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.ProjectExtern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectExternRepository extends JpaRepository<ProjectExtern, Long> {

    ProjectExtern findById(long codigo);
}
