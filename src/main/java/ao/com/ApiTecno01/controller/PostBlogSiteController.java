package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.PostBlogSite;
import ao.com.ApiTecno01.repository.CategoryRepository;
import ao.com.ApiTecno01.repository.PostBlogSiteRepository;
import ao.com.ApiTecno01.service.PostBlogSiteService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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
public class PostBlogSiteController {

    @Autowired
    private final PostBlogSiteService postBlogSiteService;

    @Autowired
    private final PostBlogSiteRepository postBlogSiteRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    private static final String caminhoImagemPostBlogSite = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/postBlogSites
    @GetMapping("/postBlogSites")
    public List<PostBlogSite> getAllServico() {
        return postBlogSiteService.getAllPostBlogSite();
    }

    //http://localhost:8080/api/exibirImagmpostBlogSites/imagemBanner
    @GetMapping("/exibirImagemPostBlogSite/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmpostBlogSite(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemPostBlogSite + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/postBlogSite/1
    @GetMapping("/postBlogSite/{codigo}")
    public PostBlogSite porCodigo(@PathVariable Long codigo) {
        return postBlogSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/postBlogSite
    @PostMapping(value = "/postBlogSite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarPostBlogSite(PostBlogSite postBlogSite, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemPostBlogSite + String.valueOf(postBlogSite.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                postBlogSite.setImageUrl(String.valueOf(postBlogSite.getCodigo()) + arquivo.getOriginalFilename());
                postBlogSite.setDataP(LocalDateTime.now());
                postBlogSiteRepository.save(postBlogSite);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/postBlogSite
    @PutMapping(value = "/postBlogSite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updatePostBlogSite(PostBlogSite postBlogSite, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemPostBlogSite + String.valueOf(postBlogSite.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                postBlogSite.setImageUrl(String.valueOf(postBlogSite.getCodigo()) + arquivo.getOriginalFilename());
                postBlogSiteRepository.save(postBlogSite);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/postBlogSite   
    @DeleteMapping("/postBlogSite/{codigo}")
    public void deletePostBlogSite(@PathVariable(value = "codigo") long codigo) {
        postBlogSiteService.deletePostBlogSite(codigo);
    }

}
