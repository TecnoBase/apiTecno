package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
public class InscricoesExternasNormal extends GenericDomin {

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
    @JoinColumn(name = "formationNormal_codigo")
    private FormationNormal formationNormal;
    
    @OneToMany(mappedBy = "inscricoesExternasNormal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Pagamento> pagamentos;

}
