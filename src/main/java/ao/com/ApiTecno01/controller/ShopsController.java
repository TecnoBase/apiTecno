package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Shops;
import ao.com.ApiTecno01.repository.ShopsRepository;
import ao.com.ApiTecno01.service.ShopsService;
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
public class ShopsController {
    
  
   
@Autowired
    private final ShopsService shopsService;
    
    @Autowired
    private final ShopsRepository shopsRepository;

    private static final String caminhoImagemShops = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/shopss
    @GetMapping("/shopss")
    public List<Shops> getAllServico() {
        return shopsService.getAllShops();
    }

    //http://localhost:8080/api/exibirImagmshopss/imagemBanner
    @GetMapping("/exibirImagemShops/{imageUrl}")
    @ResponseBody
    public byte[] exibirImagmshops(@PathVariable("imageUrl") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemShops + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/shops/1
    @GetMapping("/shops/{codigo}")
    public Shops getPorCodigo(@PathVariable Long codigo) {
        return shopsService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/shops
    @PostMapping(value = "/shops", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarShops(Shops shops, BindingResult result, @RequestParam("imageUrl") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemShops + String.valueOf(shops.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                shops.setImageUrl(String.valueOf(shops.getCodigo()) + arquivo.getOriginalFilename());
                shopsRepository.save(shops);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/shops

    @PutMapping("/shops")
    public Shops updateShops(@RequestBody Shops shops) {
        return shopsService.updateShops(shops);
    }

    //http://localhost:8080/api/shops   
    @DeleteMapping("/shops/{codigo}")
    public void deleteShops(@PathVariable(value = "codigo") long codigo) {
        shopsService.deleteShops(codigo);
    }

}

