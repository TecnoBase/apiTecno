package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class InscricoesExternasTreinamento extends GenericDomin {

    @Lob
    @Column(nullable = false)
    private String foto;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 50)
    private String phoneNumber;
    @Column(nullable = false, length = 50)
    private String provincia;
    @Column(nullable = false, length = 50)
    private String bi;
    @Enumerated(EnumType.STRING)
    private StatusCurso statusCurso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formationEspecialTreinamento_codigo")
    private FormationEspecialTreinamento formationEspecialTreinamento;
}
