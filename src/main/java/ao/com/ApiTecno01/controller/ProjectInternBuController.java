package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.ProjectInternBu;
import ao.com.ApiTecno01.repository.ProjectInternBuRepository;
import ao.com.ApiTecno01.service.ProjectInternBuService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class ProjectInternBuController {
    
@Autowired
    private final ProjectInternBuService projectInternBuService;
    
    @Autowired
    private final ProjectInternBuRepository projectInternBuRepository;

    private static final String caminhoImagemProjectInternBu = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/projectInternBus
    @GetMapping("/projectInternBus")
    public List<ProjectInternBu> getAllServico() {
        return projectInternBuService.getAllProjectInternBu();
    }

    //http://localhost:8080/api/exibirImagmprojectInternBus/imagemBanner
    @GetMapping("/exibirImagemProjectInternBu/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmprojectInternBu(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemProjectInternBu + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/projectInternBu/1
    @GetMapping("/projectInternBu/{codigo}")
    public ProjectInternBu getPorCodigo(@PathVariable Long codigo) {
        return projectInternBuService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/projectInternBu
    @PostMapping(value = "/projectInternBu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarProjectInternBu(ProjectInternBu projectInternBu, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemProjectInternBu + String.valueOf(projectInternBu.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                projectInternBu.setImageUrl(String.valueOf(projectInternBu.getCodigo()) + arquivo.getOriginalFilename());
                projectInternBuRepository.save(projectInternBu);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/projectInternBu

    @PutMapping("/projectInternBu")
    public ProjectInternBu updateProjectInternBu(@RequestBody ProjectInternBu projectInternBu) {
        return projectInternBuService.updateProjectInternBu(projectInternBu);
    }

    //http://localhost:8080/api/projectInternBu   
    @DeleteMapping("/projectInternBu/{codigo}")
    public void deleteProjectInternBu(@PathVariable(value = "codigo") long codigo) {
        projectInternBuService.deleteProjectInternBu(codigo);
    }

}


