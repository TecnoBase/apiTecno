package ao.com.ApiTecno01.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
public class Evento extends GenericDomin {

    @Lob
    @Column(nullable = false)
    private String imageUrl;
    @Lob
    @Column(columnDefinition = "text")
    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String source;
    @Lob
    @Column(columnDefinition = "text")
    private String link;

}
