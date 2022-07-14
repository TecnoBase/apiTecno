package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
    
    Tag findById(long codigo);
}
