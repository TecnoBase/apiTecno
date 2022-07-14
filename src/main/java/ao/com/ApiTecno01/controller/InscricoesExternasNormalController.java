package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.InscricoesExternasNormal;
import ao.com.ApiTecno01.repository.InscricoesExternasNormalRepository;
import ao.com.ApiTecno01.repository.PagamentoRepository;
import ao.com.ApiTecno01.service.InscricoesExternasNormalService;
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
public class InscricoesExternasNormalController {

    @Autowired
    private final InscricoesExternasNormalService inscricoesExternasNormalSiteService;

    @Autowired
    private final InscricoesExternasNormalRepository inscricoesExternasNormalRepository;
    
   @Autowired
    private final PagamentoRepository pagamentoRepository;

    private static final String caminhoImagemInscricoesExternasNormal = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/inscricoesExternasNormals
    @GetMapping("/inscricoesExternasNormals")
    public List<InscricoesExternasNormal> getAllServico() {
        return inscricoesExternasNormalSiteService.getAllFormationEspecialTreinamento();
    }

    //http://localhost:8080/api/exibirImagminscricoesExternasNormals/foto
    @GetMapping("/exibirImagemInscricoesExternasNormal/{foto}")
    @ResponseBody
    public byte[] exibirImagminscricoesExternasNormal(@PathVariable("foto") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemInscricoesExternasNormal + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/inscricoesExternasNormal/1
    @GetMapping("/inscricoesExternasNormal/{codigo}")
    public InscricoesExternasNormal porCodigo(@PathVariable Long codigo) {
        return inscricoesExternasNormalSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/inscricoesExternasNormal
    @PostMapping(value = "/inscricoesExternasNormal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarInscricoesExternasNormal(InscricoesExternasNormal inscricoesExternasNormal, BindingResult result, @RequestParam("foto") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemInscricoesExternasNormal + String.valueOf(inscricoesExternasNormal.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                inscricoesExternasNormal.setFoto(String.valueOf(inscricoesExternasNormal.getCodigo()) + arquivo.getOriginalFilename());
                inscricoesExternasNormalRepository.save(inscricoesExternasNormal);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
//  addFormationNormalRepository
//    public ResponseEntity<InscricoesExternasNormal> addFormation(Long codigo, Pagamento pagamento){
//        InscricoesExternasNormal inscNormal = inscricoesExternasNormalRepository.getOne(codigo);
//        inscNormal.getFormationNormal().add
//    }
//    

    //http://localhost:8080/api/inscricoesExternasNormal
    @PutMapping(value = "/inscricoesExternasNormal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updateInscricoesExternasNormal(InscricoesExternasNormal inscricoesExternasNormal, BindingResult result, @RequestParam("foto") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemInscricoesExternasNormal + String.valueOf(inscricoesExternasNormal.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                inscricoesExternasNormal.setFoto(String.valueOf(inscricoesExternasNormal.getCodigo()) + arquivo.getOriginalFilename());
                inscricoesExternasNormalRepository.save(inscricoesExternasNormal);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/inscricoesExternasNormal   
    @DeleteMapping("/inscricoesExternasNormal/{codigo}")
    public void deleteInscricoesExternasNormal(@PathVariable(value = "codigo") long codigo) {
        inscricoesExternasNormalSiteService.deleteInscricoesExternasNormal(codigo);
    }

}
