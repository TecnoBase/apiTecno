package ao.com.ApiTecno01.repository;

import ao.com.ApiTecno01.models.PostBlogSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostBlogSiteRepository extends JpaRepository<PostBlogSite, Long> {

    PostBlogSite findById(long codigo);
}
