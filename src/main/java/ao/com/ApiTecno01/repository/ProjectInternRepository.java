package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.ProjectIntern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectInternRepository extends JpaRepository<ProjectIntern, Long> {

    ProjectIntern findById(long codigo);
}
