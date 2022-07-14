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
public class FormationBanner extends GenericDomin {

    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 50)
    private String subtitle;
    @Lob
    @Column(columnDefinition = "text")
    private String description;
}
