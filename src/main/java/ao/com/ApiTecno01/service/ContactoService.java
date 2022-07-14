package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.Contacto;
import ao.com.ApiTecno01.models.StatusContacto;
import ao.com.ApiTecno01.repository.ContactoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactoService {

    @Autowired
    private final ContactoRepository caContactoRepository;

    //LISTAR
    public List<Contacto> getAllContacto() {
        return caContactoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Contacto getPorCodigo(long codigo) {
        return caContactoRepository.findById(codigo);
    }

    //CRIAR
    public Contacto createContacto(Contacto contactoSite) {
        contactoSite.setStatusContacto(StatusContacto.PEDENTE);
        return caContactoRepository.save(contactoSite);
    }

    //ACTUALIZAR
    public Contacto updateContacto(Contacto contactoSite) {
        return caContactoRepository.save(contactoSite);
    }

    //ELIMINAR
    public void deleteContacto(long codigo) {
        caContactoRepository.deleteById(codigo);
    }
}
