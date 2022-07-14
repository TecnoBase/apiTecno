package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class PostBlogSite extends GenericDomin {

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    private LocalDateTime dataP;

    @Lob
    @Column(columnDefinition = "text")
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_codigo")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "postBlogSite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "postBlogSite_tag", joinColumns = @JoinColumn(name = "postBlogSite_codigo", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "tag_codigo", referencedColumnName = "codigo"))
    private List<Tag> tags;

}
