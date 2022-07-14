package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.ServicePrestado;
import ao.com.ApiTecno01.repository.ServicePrestadoRepository;
import ao.com.ApiTecno01.service.ServicePrestadoService;
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
public class ServicePrestadoController {

    @Autowired
    private final ServicePrestadoService servicePrestadoService;

    @Autowired
    private final ServicePrestadoRepository servicePrestadoRepository;

    private static final String caminhoImagemServicePrestado = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/servicePrestados
    @GetMapping("/servicePrestados")
    public List<ServicePrestado> getAllServico() {
        return servicePrestadoService.getAllServicePrestado();
    }

    //http://localhost:8080/api/exibirImagmservicePrestados/imagemBanner
    @GetMapping("/exibirImagemServicePrestado/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmservicePrestado(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemServicePrestado + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/servicePrestado/1
    @GetMapping("/servicePrestado/{codigo}")
    public ServicePrestado porCodigo(@PathVariable Long codigo) {
        return servicePrestadoService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/servicePrestado
    @PostMapping(value = "/servicePrestado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarServicePrestado(ServicePrestado servicePrestado, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemServicePrestado + String.valueOf(servicePrestado.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                servicePrestado.setImageUrl(String.valueOf(servicePrestado.getCodigo()) + arquivo.getOriginalFilename());
                servicePrestadoRepository.save(servicePrestado);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/servicePrestado

    @PutMapping("/servicePrestado")
    public ServicePrestado updateServicePrestado(@RequestBody ServicePrestado servicePrestado) {
        return servicePrestadoService.updateServicePrestado(servicePrestado);
    }

    //http://localhost:8080/api/servicePrestado   
    @DeleteMapping("/servicePrestado/{codigo}")
    public void deleteServicePrestado(@PathVariable(value = "codigo") long codigo) {
        servicePrestadoService.deleteServicePrestado(codigo);
    }

}
