package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Services;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    Services findById(long codigo);

    @Query("select s from Services s where s.title like %?1% ")
    List<Services> findPessoaByName(String title);

}
