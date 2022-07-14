package ao.com.ApiTecno01.service;

;
import ao.com.ApiTecno01.models.ServicesBanner;
import ao.com.ApiTecno01.repository.ServicesBannerRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServicesBannerService {
    

    @Autowired
    private final ServicesBannerRepository servicesBannerRepository;

    public List<ServicesBanner> listarServices() {
        List<ServicesBanner> services = new ArrayList<>();
        servicesBannerRepository.findAll().forEach(services::add);
        return services;
    }

    //BUSCAR POR CODIGO
    public ServicesBanner getPorCodigo(long codigo) {
        return servicesBannerRepository.findById(codigo);
    }

    //CRIAR
    public ServicesBanner createServices(ServicesBanner services) {
        return servicesBannerRepository.save(services);
    }

    //ACTUALIZAR
    public ServicesBanner updateServices(ServicesBanner services) {
        return servicesBannerRepository.save(services);
    }

    //ELIMINAR
    public void deleteServices(long codigo) {
        servicesBannerRepository.deleteById(codigo);
    }

}


