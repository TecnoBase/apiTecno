package ao.com.ApiTecno01.service;

import ao.com.ApiTecno01.models.Newsletter;
import ao.com.ApiTecno01.repository.NewsletterRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NewsletterService {

    @Autowired
    private final NewsletterRepository caNewsletterRepository;

    //LISTAR
    public List<Newsletter> getAllNewsletter() {
        return caNewsletterRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Newsletter getPorCodigo(long codigo) {
        return caNewsletterRepository.findById(codigo);
    }

    //CRIAR
    public Newsletter createNewsletter(Newsletter newsletterSite) {
        return caNewsletterRepository.save(newsletterSite);
    }

    //ACTUALIZAR
    public Newsletter updateNewsletter(Newsletter newsletterSite) {
        return caNewsletterRepository.save(newsletterSite);
    }
        //ELIMINAR
    public void deleteNewsletter(long codigo) {
        caNewsletterRepository.deleteById(codigo);
    }
}
