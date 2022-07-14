package ao.com.ApiTecno01.repository;


import ao.com.ApiTecno01.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long codigo);
}
