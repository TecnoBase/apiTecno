package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.ProjectInternBu;
import ao.com.ApiTecno01.repository.ProjectInternBuRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class ProjectInternBuService {

    @Autowired
    private final ProjectInternBuRepository projectInternBuRepository;

    //LISTAR
    public List<ProjectInternBu> getAllProjectInternBu() {
        return projectInternBuRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public ProjectInternBu getPorCodigo(long codigo) {
        return projectInternBuRepository.findById(codigo);
    }

    //CRIAR
    public ProjectInternBu createProjectInternBu(ProjectInternBu formation, MultipartFile file) {
        return projectInternBuRepository.save(formation);
    }

    //ACTUALIZAR
    public ProjectInternBu updateProjectInternBu(ProjectInternBu formation) {
        return projectInternBuRepository.save(formation);
    }

    //ELIMINAR
    public void deleteProjectInternBu(long codigo) {
        projectInternBuRepository.deleteById(codigo);
    }
}
