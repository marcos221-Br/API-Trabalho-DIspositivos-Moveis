package api.utfpr.ddm.models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "carroimagens")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarroImagem implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    private Carro carro;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "imagem", referencedColumnName = "id", nullable = false)
    private Imagem imagem;

    public CarroImagem(Carro carro, Imagem imagem){
        this.carro = carro;
        this.imagem = imagem;
    }
}
