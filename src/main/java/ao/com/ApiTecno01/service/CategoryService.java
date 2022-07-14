package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Category;
import ao.com.ApiTecno01.repository.CategoryRepository;
import ao.com.ApiTecno01.repository.PostBlogSiteRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostBlogSiteRepository postBlogSiteRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Category getPorCodigo(long codigo) {
        return categoryRepository.findById(codigo);
    }

    //CRIAR
    public Category createCategory(Category categorySite) {
        return categoryRepository.save(categorySite);
    }

    //ACTUALIZAR
    public Category updateCategory(Category categorySite) {
        return categoryRepository.save(categorySite);
    }

    //ELIMINAR
    public void deleteCategory(long codigo) {
        categoryRepository.deleteById(codigo);
    }

}
