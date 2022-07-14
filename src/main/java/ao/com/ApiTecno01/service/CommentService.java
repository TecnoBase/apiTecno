package ao.com.ApiTecno01.service;


import ao.com.ApiTecno01.models.Comment;
import ao.com.ApiTecno01.repository.CommentRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentService {

    @Autowired
    private final CommentRepository caCommentRepository;

    //LISTAR
    public List<Comment> getAllComment() {
        return caCommentRepository.findAll();
    }

    //BUSCAR POR CODIGO
    public Comment getPorCodigo(long codigo) {
        return caCommentRepository.findById(codigo);
    }

    //CRIAR
    public Comment createComment(Comment commentSite) {
//        commentSite.setStatusComment(StatusComment.PEDENTE);
        commentSite.setCommentDate(LocalDateTime.now());
        return caCommentRepository.save(commentSite);
    }

    //ACTUALIZAR
    public Comment updateComment(Comment commentSite) {
        return caCommentRepository.save(commentSite);
    }

    //ELIMINAR
    public void deleteComment(long codigo) {
        caCommentRepository.deleteById(codigo);
    }
}
