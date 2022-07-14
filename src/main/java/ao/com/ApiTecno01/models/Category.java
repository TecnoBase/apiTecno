package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Category extends GenericDomin{
    	@Column(nullable = false, length = 100)
	private String nome;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
	private List<PostBlogSite> postBlogSites;
}
