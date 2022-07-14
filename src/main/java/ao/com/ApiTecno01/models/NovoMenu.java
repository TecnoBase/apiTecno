package ao.com.ApiTecno01.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@SuppressWarnings("serial")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
@Embeddable
public class NovoMenu implements Serializable {

    @Column(nullable = false, length = 50)
    private String novoMenu;
}
