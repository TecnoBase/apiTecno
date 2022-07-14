package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.ProjectIntern;
import ao.com.ApiTecno01.repository.ProjectInternRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class ProjectInternService {

    @Autowired
    private final ProjectInternRepository projectInternRepository;

    //LISTAR
    public List<ProjectIntern> getAllProjectIntern() {
        return projectInternRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public ProjectIntern getPorCodigo(long codigo) {
        return projectInternRepository.findById(codigo);
    }

    //CRIAR
    public ProjectIntern createProjectIntern(ProjectIntern formation, MultipartFile file) {
        return projectInternRepository.save(formation);
    }

    //ACTUALIZAR
    public ProjectIntern updateProjectIntern(ProjectIntern formation) {
        return projectInternRepository.save(formation);
    }

    //ELIMINAR
    public void deleteProjectIntern(long codigo) {
        projectInternRepository.deleteById(codigo);
    }
}
