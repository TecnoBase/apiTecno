package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.Newsletter;
import ao.com.ApiTecno01.service.NewsletterService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class NewsletterController {

    @Autowired
    private final NewsletterService newsletterSiteService;

    //http://localhost:8080/api/newsletterSites
    @GetMapping("/newsletterSites")
    public List<Newsletter> getAllNewsletter() {
        return newsletterSiteService.getAllNewsletter();
    }

    //http://localhost:8080/api/newsletterSite/1
    @GetMapping("/newsletterSite/{codigo}")
    public Newsletter getPorCodigo(@PathVariable Long codigo) {
        return newsletterSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/newsletterSite
    @PostMapping("/newsletterSite")
    public Newsletter createNewsletter(@RequestBody Newsletter newsletterSite) {
        return newsletterSiteService.createNewsletter(newsletterSite);
    }

    //http://localhost:8080/api/newsletterSite
    @PutMapping("/newsletterSite")
    public Newsletter updateNewsletter(@RequestBody Newsletter newsletterSite) {
        return newsletterSiteService.updateNewsletter(newsletterSite);
    }

    //http://localhost:8080/api/newsletterSite/1 
    @DeleteMapping("/newsletterSite/{codigo}")
    public void deleteNewsletter(@PathVariable(value = "codigo") long codigo) {
        newsletterSiteService.deleteNewsletter(codigo);
    }

}
