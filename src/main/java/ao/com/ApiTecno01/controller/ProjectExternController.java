package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.ProjectExtern;
import ao.com.ApiTecno01.repository.ProjectExternRepository;
import ao.com.ApiTecno01.service.ProjectExternService;
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
public class ProjectExternController {
    
@Autowired
    private final ProjectExternService projectExternService;
    
    @Autowired
    private final ProjectExternRepository projectExternRepository;

    private static final String caminhoImagemProjectExtern = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/projectExterns
    @GetMapping("/projectExterns")
    public List<ProjectExtern> getAllServico() {
        return projectExternService.getAllProjectExtern();
    }

    //http://localhost:8080/api/exibirImagmprojectExterns/imagemBanner
    @GetMapping("/exibirImagemProjectExtern/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmprojectExtern(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemProjectExtern + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/projectExtern/1
    @GetMapping("/projectExtern/{codigo}")
    public ProjectExtern getPorCodigo(@PathVariable Long codigo) {
        return projectExternService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/projectExtern
    @PostMapping(value = "/projectExtern", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarProjectExtern(ProjectExtern projectExtern, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemProjectExtern + String.valueOf(projectExtern.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                projectExtern.setImageUrl(String.valueOf(projectExtern.getCodigo()) + arquivo.getOriginalFilename());
                projectExternRepository.save(projectExtern);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/projectExtern

    @PutMapping("/projectExtern")
    public ProjectExtern updateProjectExtern(@RequestBody ProjectExtern projectExtern) {
        return projectExternService.updateProjectExtern(projectExtern);
    }

    //http://localhost:8080/api/projectExtern   
    @DeleteMapping("/projectExtern/{codigo}")
    public void deleteProjectExtern(@PathVariable(value = "codigo") long codigo) {
        projectExternService.deleteProjectExtern(codigo);
    }

}


