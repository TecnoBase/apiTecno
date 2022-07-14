package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Category;
import ao.com.ApiTecno01.models.PostBlogSite;
import ao.com.ApiTecno01.repository.CategoryRepository;
import ao.com.ApiTecno01.repository.PostBlogSiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class PostBlogSiteService {

    @Autowired
    private final PostBlogSiteRepository postBlogSiteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //LISTAR
//    public List<PostBlogSite> getAllPosts(int page, int size) {
//        validatePageNumberAndSize(page, size);
////  Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
//        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
//
//        Page<PostBlogSite> posts = postRepository.findAll(pageable);
//
//        List<PostBlogSite> content = posts.getNumberOfElements() == 0 ? Collections.emptyList() : posts.getContent();
//
//        return new PagedResponse<>(content, posts.getNumber(), posts.getSize(), posts.getTotalElements(),
//                posts.getTotalPages(), posts.isLast());
//    }
    //LISTAR
    public List<PostBlogSite> getAllPostBlogSite() {
        return postBlogSiteRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public PostBlogSite getPorCodigo(long codigo) {
        return postBlogSiteRepository.findById(codigo);
    }

    //CRIAR
    public PostBlogSite createPostBlogSite(PostBlogSite postBlogSite, MultipartFile file) {
//        postBlogSite.setDataP(LocalDate.now());
        return postBlogSiteRepository.save(postBlogSite);
    }

    //ACTUALIZAR
    public PostBlogSite updatePostBlogSite(PostBlogSite postBlogSite, MultipartFile file) {
        return postBlogSiteRepository.save(postBlogSite);
    }

    //ACTUALIZAR
    public PostBlogSite updateEmpCategory(Integer post_codigo, Integer cat_codigo) {
//        PostBlogSite postBlogSite = postBlogSiteRepository.findById(emp_id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"PostBlogSite not found with id : "+emp_id) );
        PostBlogSite postBlogSite = postBlogSiteRepository.findById(post_codigo);

//        Category category = categoryRepository.findById(dept_id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found with id : "+emp_id) );;
        Category category = categoryRepository.findById(cat_codigo);

        postBlogSite.setCategory(category);
        postBlogSiteRepository.save(postBlogSite);

        return postBlogSite;
    }

    //ELIMINAR
    public void deletePostBlogSite(long codigo) {
        postBlogSiteRepository.deleteById(codigo);
    }

    //
//    private void validatePageNumberAndSize(int page, int size) {
//        if (page < 0) {
//            throw new BadRequestException("Page number cannot be less than zero.");
//        }
//
//        if (size < 0) {
//            throw new BadRequestException("Size number cannot be less than zero.");
//        }
//      
//    }
}
