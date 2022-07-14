package ao.com.ApiTecno01.controller;

import ao.com.ApiTecno01.models.Category;
import ao.com.ApiTecno01.service.CategoryService;
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
public class CategoryController {
    

    @Autowired
    private final CategoryService categorySiteService;

    //http://localhost:8080/api/categorySites
    @GetMapping("/categorySites")
    public List<Category> getAllCategory() {
        return categorySiteService.getAllCategory();
    }

    //http://localhost:8080/api/categorySite/1
    @GetMapping("/categorySite/{codigo}")
    public Category getPorCodigo(@PathVariable Long codigo) {
        return categorySiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/categorySite
    @PostMapping("/categorySite")
    public Category createCategory(@RequestBody Category categorySite) {
        return categorySiteService.createCategory(categorySite);
    }

    //http://localhost:8080/api/categorySite
    @PutMapping("/categorySite")
    public Category updateCategory(@RequestBody Category categorySite) {
        return categorySiteService.updateCategory(categorySite);
    }

    //http://localhost:8080/api/categorySite/1 
    @DeleteMapping("/categorySite/{codigo}")
    public void deleteCategory(@PathVariable(value = "codigo") long codigo) {
        categorySiteService.deleteCategory(codigo);
    }

}

