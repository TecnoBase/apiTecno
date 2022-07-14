package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.ServicePrestado;
import ao.com.ApiTecno01.repository.ServicePrestadoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class ServicePrestadoService {

    @Autowired
    private final ServicePrestadoRepository servicePrestadoRepository;

    //LISTAR
    public List<ServicePrestado> getAllServicePrestado() {
        return servicePrestadoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public ServicePrestado getPorCodigo(long codigo) {
        return servicePrestadoRepository.findById(codigo);
    }

    //CRIAR
    public ServicePrestado createServicePrestado(ServicePrestado servicePrestado, MultipartFile file) {
        return servicePrestadoRepository.save(servicePrestado);
    }

    //ACTUALIZAR
    public ServicePrestado updateServicePrestado(ServicePrestado servicePrestado) {
        return servicePrestadoRepository.save(servicePrestado);
    }

    //ELIMINAR
    public void deleteServicePrestado(long codigo) {
        servicePrestadoRepository.deleteById(codigo);
    }
}
