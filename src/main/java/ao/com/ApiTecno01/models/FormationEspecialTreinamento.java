package ao.com.ApiTecno01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
public class FormationEspecialTreinamento extends GenericDomin {

    @Lob
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 50)
    private String duration;
    @Column(nullable = false, length = 50)
    private String payment;
    @Column(precision = 10, scale = 2, nullable = false)
    private double price;
    @Column(precision = 10, scale = 2, nullable = false)
    private double descount;
    @OneToMany(mappedBy = "formationEspecialTreinamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<InscricoesExternasTreinamento> inscricoesExternasTreinamentos;
}
