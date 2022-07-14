package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.ProjectIntern;
import ao.com.ApiTecno01.repository.ProjectInternRepository;
import ao.com.ApiTecno01.service.ProjectInternService;
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
public class ProjectInternController {
    
   
   
@Autowired
    private final ProjectInternService projectInternService;
    
    @Autowired
    private final ProjectInternRepository projectInternRepository;

    private static final String caminhoImagemProjectIntern = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/projectInterns
    @GetMapping("/projectInterns")
    public List<ProjectIntern> getAllServico() {
        return projectInternService.getAllProjectIntern();
    }

    //http://localhost:8080/api/exibirImagmprojectInterns/imagemBanner
    @GetMapping("/exibirImagemProjectIntern/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmprojectIntern(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemProjectIntern + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/projectIntern/1
    @GetMapping("/projectIntern/{codigo}")
    public ProjectIntern getPorCodigo(@PathVariable Long codigo) {
        return projectInternService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/projectIntern
    @PostMapping(value = "/projectIntern", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarProjectIntern(ProjectIntern projectIntern, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemProjectIntern + String.valueOf(projectIntern.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                projectIntern.setImageUrl(String.valueOf(projectIntern.getCodigo()) + arquivo.getOriginalFilename());
                projectInternRepository.save(projectIntern);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/projectIntern

    @PutMapping("/projectIntern")
    public ProjectIntern updateProjectIntern(@RequestBody ProjectIntern projectIntern) {
        return projectInternService.updateProjectIntern(projectIntern);
    }

    //http://localhost:8080/api/projectIntern   
    @DeleteMapping("/projectIntern/{codigo}")
    public void deleteProjectIntern(@PathVariable(value = "codigo") long codigo) {
        projectInternService.deleteProjectIntern(codigo);
    }

}

