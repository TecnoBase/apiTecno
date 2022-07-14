package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.FormationNormal;
import ao.com.ApiTecno01.repository.FormationNormalRepository;
import ao.com.ApiTecno01.service.FormationNormalService;
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
public class FormationNormalController {
    

    @Autowired
    private final FormationNormalService formationNormalService;

    @Autowired
    private final FormationNormalRepository formationNormalRepository;

    private static final String caminhoImagemFormationNormal = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/formationNormals
    @GetMapping("/formationNormals")
    public List<FormationNormal> getAllServico() {
        return formationNormalService.getAllFormationNormal();
    }

    //http://localhost:8080/api/exibirImagmformationNormals/imagemBanner
    @GetMapping("/exibirImagemFormationNormal/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmformationNormal(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemFormationNormal + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/formationNormal/1
    @GetMapping("/formationNormal/{codigo}")
    public FormationNormal porCodigo(@PathVariable Long codigo) {
        return formationNormalService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/formationNormal
    @PostMapping(value = "/formationNormal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarFormationNormal(FormationNormal formationNormal, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemFormationNormal + String.valueOf(formationNormal.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                formationNormal.setImageUrl(String.valueOf(formationNormal.getCodigo()) + arquivo.getOriginalFilename());
                formationNormalRepository.save(formationNormal);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/formationNormal
    @PutMapping(value = "/formationNormal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updateFormationNormal(FormationNormal formationNormal, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemFormationNormal + String.valueOf(formationNormal.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                formationNormal.setImageUrl(String.valueOf(formationNormal.getCodigo()) + arquivo.getOriginalFilename());
                formationNormalRepository.save(formationNormal);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/formationNormal   
    @DeleteMapping("/formationNormal/{codigo}")
    public void deleteFormationNormal(@PathVariable(value = "codigo") long codigo) {
        formationNormalService.deleteFormationNormal(codigo);
    }

}

