package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag extends GenericDomin {

    @Column(nullable = false, length = 100)
    private String nome;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "postBlogSite_tag", joinColumns = @JoinColumn(name = "tag_codigo", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "postBlogSite_codigo", referencedColumnName = "codigo"))
    private List<PostBlogSite> postBlogSites;
}
