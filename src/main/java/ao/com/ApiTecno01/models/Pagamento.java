package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
public class Pagamento extends GenericDomin {

    @Lob
    @Column(nullable = false)
    private String pdf;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inscricoesExternasNormal_codigo")
    private InscricoesExternasNormal inscricoesExternasNormal;

}
