package ao.com.ApiTecno01.models;

import javax.persistence.Column;
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
public class Usuario extends GenericDomin {

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
}
