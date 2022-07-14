package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.ServicePrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePrestadoRepository extends JpaRepository<ServicePrestado, Long> {

    ServicePrestado findById(long codigo);
}
