package ao.com.ApiTecno01.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Contacto extends GenericDomin{
    
    @Column(nullable = false, length = 90)
    private String email;
    @Column(nullable = false, length = 50)
    private String assunto;
    @Lob
    @Column(columnDefinition = "text")
    private String mensagem;
    
        
    @Enumerated(EnumType.STRING)
    private StatusContacto statusContacto;
}
