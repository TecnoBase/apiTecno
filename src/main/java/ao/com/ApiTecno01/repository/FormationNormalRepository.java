package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.FormationNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationNormalRepository extends JpaRepository<FormationNormal, Long> {

    FormationNormal findById(long codigo);
}
