package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.Pagamento;
import ao.com.ApiTecno01.repository.PagamentoRepository;
import ao.com.ApiTecno01.service.PagamentoService;
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
public class PagamentoController {

    @Autowired
    private final PagamentoService pagamentoSiteService;

    @Autowired
    private final PagamentoRepository pagamentoRepository;

    private static final String caminhoImagemPagamento = "/home/tecnobase/Documentos/upload/";

    //http://localhost:8080/api/pagamentos
    @GetMapping("/pagamentos")
    public List<Pagamento> getAllServico() {
        return pagamentoSiteService.getAllPagamento();
    }

    //http://localhost:8080/api/exibirPdfPagamento/pdf
    @GetMapping("/exibirPdfPagamento/{pdf}")
    @ResponseBody
    public byte[] exibirPdfpagamento(@PathVariable("pdf") String pdf) throws IOException {
        System.out.println(pdf);
        File imagemBanner = new File(caminhoImagemPagamento + pdf);
        if (pdf != null || pdf.trim().length() > 0) {
            System.out.println("NO IF");
            return Files.readAllBytes(imagemBanner.toPath());
        }
        return null;
    }

    //http://localhost:8080/api/pagamento/1
    @GetMapping("/pagamento/{codigo}")
    public Pagamento porCodigo(@PathVariable Long codigo) {
        return pagamentoSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/pagamento
    @PostMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarPagamento(Pagamento pagamento, BindingResult result, @RequestParam("pdf") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemPagamento + String.valueOf(pagamento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                pagamento.setPdf(String.valueOf(pagamento.getCodigo()) + arquivo.getOriginalFilename());
                pagamentoRepository.save(pagamento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/pagamento
    @PutMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updatePagamento(Pagamento pagamento, BindingResult result, @RequestParam("pdf") MultipartFile arquivo) {

        try {
            //Condição que salva a imagem no caminho da pasta
            if (!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagemPagamento + String.valueOf(pagamento.getCodigo()) + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);
                pagamento.setPdf(String.valueOf(pagamento.getCodigo()) + arquivo.getOriginalFilename());
                pagamentoRepository.save(pagamento);

            } else {
                result.hasErrors();
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salvo com sucesso!";
    }

    //http://localhost:8080/api/pagamento   
    @DeleteMapping("/pagamento/{codigo}")
    public void deletePagamento(@PathVariable(value = "codigo") long codigo) {
        pagamentoSiteService.deletePagamento(codigo);
    }

}
