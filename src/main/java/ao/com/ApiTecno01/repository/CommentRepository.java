package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findById(long codigo);
}
