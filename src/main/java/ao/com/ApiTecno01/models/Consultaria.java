/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.ApiTecno01.models;

import java.math.BigDecimal;
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
public class Consultaria extends GenericDomin {

    @Column(nullable = false, length = 50)
    private String title;
    @Lob
    @Column(nullable = false)
    private String imageUrl;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;
    @Column(nullable = false, length = 50)
    private String tempo;
}
