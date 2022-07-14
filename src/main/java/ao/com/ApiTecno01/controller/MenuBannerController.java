package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.MenuBanner;
import ao.com.ApiTecno01.repository.MenuBannerRepository;
import ao.com.ApiTecno01.service.MenuBannerService;
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
public class MenuBannerController {

    @Autowired
    private final MenuBannerService menuBannerService;

    @Autowired
    private final MenuBannerRepository menuBannerRepository;

    private static final String caminhoImagemMenuBanner = "/home/tecnobase/Documentos/upload/";
//    private static final String caminhoImagemMenuBanner = "https://drive.google.com/drive/folders/";

    //http://localhost:8080/api/menuBanners
    @GetMapping("/menuBanners")
    public List<MenuBanner> getAllServico() {
        return menuBannerService.getAllMenuBanner();
    }

    //http://localhost:8080/api/exibirImagmmenuBanners/imagemBanner
    @GetMapping("/exibirImagemMenuBanner/{imagemBanner}")
    @ResponseBody
    public byte[] exibirImagmmenuBanner(@PathVariable("imagemBanner") String imagem) throws IOException {
        System.out.println(imagem);
        File imagemBanner = new File(caminhoImagemMenuBanner + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/menuBanner/1
    @GetMapping("/menuBanner/{codigo}")
    public MenuBanner getPorCodigo(@PathVariable Long codigo) {
        return menuBannerService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/menuBanner
    @PostMapping(value = "/menuBanner", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarMenuBanner(MenuBanner menuBanner, BindingResult result, @RequestParam("imagemBanner") MultipartFile arquivo) {

//        if(result.hasErrors()){
//            return cadastrar(menuBanner);
//        }
        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemMenuBanner + String.valueOf(menuBanner.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                menuBanner.setImagemBanner(String.valueOf(menuBanner.getCodigo()) + arquivo.getOriginalFilename());
                menuBannerRepository.save(menuBanner);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }
    //http://localhost:8080/api/menuBanner

    @PutMapping("/menuBanner")
    public MenuBanner updateMenuBanner(@RequestBody MenuBanner menuBanner) {
        return menuBannerService.updateMenuBanner(menuBanner);
    }

    //http://localhost:8080/api/menuBanner   
    @DeleteMapping("/menuBanner/{codigo}")
    public void deleteMenuBanner(@PathVariable(value = "codigo") long codigo) {
        menuBannerService.deleteMenuBanner(codigo);
    }

}
