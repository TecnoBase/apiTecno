package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Tag;
import ao.com.ApiTecno01.repository.TagRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TagService {
    
@Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }
    
    //BUSCAR POR CODIGO
    public Tag getPorCodigo(long codigo) {
        return tagRepository.findById(codigo);
    }

    //CRIAR
    public Tag createTag(Tag tagSite) {
        return tagRepository.save(tagSite);
    }

    //ACTUALIZAR
    public Tag updateTag(Tag tagSite) {
        return tagRepository.save(tagSite);
    }

    //ELIMINAR
    public void deleteTag(long codigo) {
        tagRepository.deleteById(codigo);
    }

}

