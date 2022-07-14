package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Consultaria;
import ao.com.ApiTecno01.repository.ConsultariaRepository;
import ao.com.ApiTecno01.service.ConsultariaService;
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
public class ConsultariaController {

    @Autowired
    private final ConsultariaService consultariaService;

    @Autowired
    private final ConsultariaRepository consultariaRepository;

    private static final String caminhoImagemConsultaria = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/consultarias
    @GetMapping("/consultarias")
    public List<Consultaria> getAllServico() {
        return consultariaService.getAllConsultaria();
    }

    //http://localhost:8080/api/exibirImagmconsultarias/imagemBanner
    @GetMapping("/exibirImagemConsultaria/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmconsultaria(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemConsultaria + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/consultaria/1
    @GetMapping("/consultaria/{codigo}")
    public Consultaria porCodigo(@PathVariable Long codigo) {
        return consultariaService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/consultaria
    @PostMapping(value = "/consultaria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarConsultaria(Consultaria consultaria, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemConsultaria + String.valueOf(consultaria.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                consultaria.setImageUrl(String.valueOf(consultaria.getCodigo()) + arquivo.getOriginalFilename());
                consultariaRepository.save(consultaria);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/consultaria
    @PutMapping(value = "/consultaria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updateConsultaria(Consultaria consultaria, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemConsultaria + String.valueOf(consultaria.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                consultaria.setImageUrl(String.valueOf(consultaria.getCodigo()) + arquivo.getOriginalFilename());
                consultariaRepository.save(consultaria);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/consultaria   
    @DeleteMapping("/consultaria/{codigo}")
    public void deleteConsultaria(@PathVariable(value = "codigo") long codigo) {
        consultariaService.deleteConsultaria(codigo);
    }

}
