package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.Evento;
import ao.com.ApiTecno01.repository.EventoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class EventoService {
    
 @Autowired
    private final EventoRepository eventoRepository;

    //LISTAR
    public List<Evento> getAllEvento() {
        return eventoRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Evento getPorCodigo(long codigo) {
        return eventoRepository.findById(codigo);
    }

    //CRIAR
    public Evento createEvento(Evento evento, MultipartFile file) {
        return eventoRepository.save(evento);
    }

    //ACTUALIZAR
    public Evento updateEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    //ELIMINAR
    public void deleteEvento(long codigo) {
        eventoRepository.deleteById(codigo);
    }
}

