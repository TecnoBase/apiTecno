package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.FormationEspecialTreinamento;
import ao.com.ApiTecno01.repository.FormationEspecialTreinamentoRepository;
import ao.com.ApiTecno01.service.FormationEspecialTreinamentoService;
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
public class FormationEspecialTreinamentoController {
    
   
@Autowired
    private final FormationEspecialTreinamentoService formationEspecialTreinamentoService;
    
    @Autowired
    private final FormationEspecialTreinamentoRepository formationEspecialTreinamentoRepository;

    private static final String caminhoImagemFormationEspecialTreinamento = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/formationEspecialTreinamentos
    @GetMapping("/formationEspecialTreinamentos")
    public List<FormationEspecialTreinamento> getAllServico() {
        return formationEspecialTreinamentoService.getAllFormationEspecialTreinamento();
    }

    //http://localhost:8080/api/exibirImagmformationEspecialTreinamentos/imageUrl
    @GetMapping("/exibirImagemFormationEspecialTreinamento/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmformationEspecialTreinamento(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemFormationEspecialTreinamento + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/formationEspecialTreinamento/1
    @GetMapping("/formationEspecialTreinamento/{codigo}")
    public FormationEspecialTreinamento getPorCodigo(@PathVariable Long codigo) {
        return formationEspecialTreinamentoService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/formationEspecialTreinamento
    @PostMapping(value = "/formationEspecialTreinamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarFormationEspecialTreinamento(FormationEspecialTreinamento formationEspecialTreinamento, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemFormationEspecialTreinamento + String.valueOf(formationEspecialTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                formationEspecialTreinamento.setImageUrl(String.valueOf(formationEspecialTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                formationEspecialTreinamentoRepository.save(formationEspecialTreinamento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/formationEspecialTreinamento

    @PutMapping("/formationEspecialTreinamento")
    public FormationEspecialTreinamento updateFormationEspecialTreinamento(@RequestBody FormationEspecialTreinamento formationEspecialTreinamento) {
        return formationEspecialTreinamentoService.updateFormationEspecialTreinamento(formationEspecialTreinamento);
    }

    //http://localhost:8080/api/formationEspecialTreinamento   
    @DeleteMapping("/formationEspecialTreinamento/{codigo}")
    public void deleteFormationEspecialTreinamento(@PathVariable(value = "codigo") long codigo) {
        formationEspecialTreinamentoService.deleteFormationEspecialTreinamento(codigo);
    }

}

