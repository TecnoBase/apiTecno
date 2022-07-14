package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.InscricoesExternasTreinamento;
import ao.com.ApiTecno01.repository.InscricoesExternasTreinamentoRepository;
import ao.com.ApiTecno01.service.InscricoesExternasTreinamentoService;
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
public class InscricoesExternasTreinamentoController {

    @Autowired
    private final InscricoesExternasTreinamentoService inscricoesExternasTreinamentoSiteService;

    @Autowired
    private final InscricoesExternasTreinamentoRepository inscricoesExternasTreinamentoRepository;

    private static final String caminhoImagemInscricoesExternasTreinamento = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/inscricoesExternasTreinamentos
    @GetMapping("/inscricoesExternasTreinamentos")
    public List<InscricoesExternasTreinamento> getAllServico() {
        return inscricoesExternasTreinamentoSiteService.getAllFormationEspecialTreinamento();
    }

    //http://localhost:8080/api/exibirImagminscricoesExternasTreinamentos/foto
    @GetMapping("/exibirImagemInscricoesExternasTreinamento/{foto}")
    @ResponseBody
    public byte[] exibirImagminscricoesExternasTreinamento(@PathVariable("foto") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemInscricoesExternasTreinamento + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/inscricoesExternasTreinamento/1
    @GetMapping("/inscricoesExternasTreinamento/{codigo}")
    public InscricoesExternasTreinamento porCodigo(@PathVariable Long codigo) {
        return inscricoesExternasTreinamentoSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/inscricoesExternasTreinamento
    @PostMapping(value = "/inscricoesExternasTreinamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarInscricoesExternasTreinamento(InscricoesExternasTreinamento inscricoesExternasTreinamento, BindingResult result, @RequestParam("foto") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemInscricoesExternasTreinamento + String.valueOf(inscricoesExternasTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                inscricoesExternasTreinamento.setFoto(String.valueOf(inscricoesExternasTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                inscricoesExternasTreinamentoRepository.save(inscricoesExternasTreinamento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/inscricoesExternasTreinamento
    @PutMapping(value = "/inscricoesExternasTreinamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updateInscricoesExternasTreinamento(InscricoesExternasTreinamento inscricoesExternasTreinamento, BindingResult result, @RequestParam("foto") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemInscricoesExternasTreinamento + String.valueOf(inscricoesExternasTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                inscricoesExternasTreinamento.setFoto(String.valueOf(inscricoesExternasTreinamento.getCodigo()) + arquivo.getOriginalFilename());
                inscricoesExternasTreinamentoRepository.save(inscricoesExternasTreinamento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/inscricoesExternasTreinamento   
    @DeleteMapping("/inscricoesExternasTreinamento/{codigo}")
    public void deleteInscricoesExternasTreinamento(@PathVariable(value = "codigo") long codigo) {
        inscricoesExternasTreinamentoSiteService.deleteFormationEspecialTreinamento(codigo);
    }

}
