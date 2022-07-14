package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Shops;
import ao.com.ApiTecno01.repository.ShopsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@Service
public class ShopsService {
    
    @Autowired
    private final ShopsRepository shopsRepository;

    //LISTAR
    public List<Shops> getAllShops() {
        return shopsRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Shops getPorCodigo(long codigo) {
        return shopsRepository.findById(codigo);
    }

    //CRIAR
    public Shops createShops(Shops shops, MultipartFile file) {
        return shopsRepository.save(shops);
    }

    //ACTUALIZAR
    public Shops updateShops(Shops shops) {
        return shopsRepository.save(shops);
    }

    //ELIMINAR
    public void deleteShops(long codigo) {
        shopsRepository.deleteById(codigo);
    }
}