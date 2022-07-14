package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.Consultaria;
import ao.com.ApiTecno01.repository.ConsultariaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConsultariaService {

    @Autowired
    private final ConsultariaRepository caConsultariaRepository;

    //LISTAR
    public List<Consultaria> getAllConsultaria() {
        return caConsultariaRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Consultaria getPorCodigo(long codigo) {
        return caConsultariaRepository.findById(codigo);
    }

    //CRIAR
    public Consultaria createConsultaria(Consultaria consultariaSite) {
//        consultariaSite.setStatusConsultaria(StatusConsultaria.PEDENTE);
        return caConsultariaRepository.save(consultariaSite);
    }

    //ACTUALIZAR
    public Consultaria updateConsultaria(Consultaria consultariaSite) {
        return caConsultariaRepository.save(consultariaSite);
    }

    //ELIMINAR
    public void deleteConsultaria(long codigo) {
        caConsultariaRepository.deleteById(codigo);
    }
}
