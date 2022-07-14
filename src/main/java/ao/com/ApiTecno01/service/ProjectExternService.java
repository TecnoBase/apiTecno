package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.ProjectExtern;
import ao.com.ApiTecno01.repository.ProjectExternRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class ProjectExternService {

    @Autowired
    private final ProjectExternRepository projectExternRepository;

    //LISTAR
    public List<ProjectExtern> getAllProjectExtern() {
        return projectExternRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public ProjectExtern getPorCodigo(long codigo) {
        return projectExternRepository.findById(codigo);
    }

    //CRIAR
    public ProjectExtern createProjectExtern(ProjectExtern formation, MultipartFile file) {
        return projectExternRepository.save(formation);
    }

    //ACTUALIZAR
    public ProjectExtern updateProjectExtern(ProjectExtern formation) {
        return projectExternRepository.save(formation);
    }

    //ELIMINAR
    public void deleteProjectExtern(long codigo) {
        projectExternRepository.deleteById(codigo);
    }
}
