package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Evento;
import ao.com.ApiTecno01.repository.EventoRepository;
import ao.com.ApiTecno01.service.EventoService;
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
public class EventoController {
    

   
@Autowired
    private final EventoService eventoService;
    
    @Autowired
    private final EventoRepository eventoRepository;

    private static final String caminhoImagemEvento = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/eventos
    @GetMapping("/eventos")
    public List<Evento> getAllServico() {
        return eventoService.getAllEvento();
    }

    //http://localhost:8080/api/exibirImagmeventos/imagemBanner
    @GetMapping("/exibirImagemEvento/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmevento(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemEvento + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/evento/1
    @GetMapping("/evento/{codigo}")
    public Evento porCodigo(@PathVariable Long codigo) {
        return eventoService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/evento
    @PostMapping(value = "/evento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarEvento(Evento evento, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemEvento + String.valueOf(evento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                evento.setImageUrl(String.valueOf(evento.getCodigo()) + arquivo.getOriginalFilename());
                eventoRepository.save(evento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/evento

    @PutMapping("/evento")
    public Evento updateEvento(@RequestBody Evento evento) {
        return eventoService.updateEvento(evento);
    }

    //http://localhost:8080/api/evento   
    @DeleteMapping("/evento/{codigo}")
    public void deleteEvento(@PathVariable(value = "codigo") long codigo) {
        eventoService.deleteEvento(codigo);
    }

}

