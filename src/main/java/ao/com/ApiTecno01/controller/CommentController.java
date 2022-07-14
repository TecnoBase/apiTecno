package ao.com.ApiTecno01.controller;


import ao.com.ApiTecno01.models.Comment;
import ao.com.ApiTecno01.service.CommentService;
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
public class CommentController {

    @Autowired
    private final CommentService commentSiteService;

    //http://localhost:8080/api/commentSites
    @GetMapping("/commentSites")
    public List<Comment> getAllComment() {
        return commentSiteService.getAllComment();
    }

    //http://localhost:8080/api/commentSite/1
    @GetMapping("/commentSite/{codigo}")
    public Comment getPorCodigo(@PathVariable Long codigo) {
        return commentSiteService.getPorCodigo(codigo);
    }

    //http://localhost:8080/api/commentSite
    @PostMapping("/commentSite")
    public Comment createComment(@RequestBody Comment commentSite) {
        return commentSiteService.createComment(commentSite);
    }

    //http://localhost:8080/api/commentSite
    @PutMapping("/commentSite")
    public Comment updateComment(@RequestBody Comment commentSite) {
        return commentSiteService.updateComment(commentSite);
    }

    //http://localhost:8080/api/commentSite/1 
    @DeleteMapping("/commentSite/{codigo}")
    public void deleteComment(@PathVariable(value = "codigo") long codigo) {
        commentSiteService.deleteComment(codigo);
    }

}
