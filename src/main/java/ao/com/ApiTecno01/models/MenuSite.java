package ao.com.ApiTecno01.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
public class MenuSite extends GenericDomin {

    @Column(nullable = false, length = 50)
    private String empresa;
    @Embedded
    private NovoMenu novoMenu;
}
