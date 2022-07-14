package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Services;
import ao.com.ApiTecno01.repository.ServicesRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServicesService {

    @Autowired
    private final ServicesRepository servicesRepository;

    public List<Services> listarServices() {
        return servicesRepository.findAll();

    }
//    
//    public List<Services> listarServices() {
//        Sort sort = Sort.by("title").descending();
//           Pageable pageable = PageRequest.of(0, 2, sort);
//        List<Services> services = new ArrayList<>();
//        servicesRepository.findAll(pageable).forEach(services::add);
//        return services;
//    }

    //BUSCAR POR CODIGO
    public Services getPorCodigo(long codigo) {
        return servicesRepository.findById(codigo);
    }

    //CRIAR
    public Services createServices(Services services) {
        return servicesRepository.saveAndFlush(services);
    }

    //ACTUALIZAR
    public Services updateServices(Services services) {
        return servicesRepository.save(services);
    }

    //ELIMINAR
    public void deleteServices(long codigo) {
        servicesRepository.deleteById(codigo);
    }
    //
//    private void validatePageNumberAndSize(int page, int size) {
//        if (page < 0) {
//            throw new BadRequestException("Page number cannot be less than zero.");
//        }
//
//        if (size < 0) {
//            throw new BadRequestException("Size number cannot be less than zero.");
//        }
//      
//    }
}
