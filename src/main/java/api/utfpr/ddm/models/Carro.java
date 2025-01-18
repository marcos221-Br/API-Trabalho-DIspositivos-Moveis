package api.utfpr.ddm.models;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "carros")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Carro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "marca", nullable = false)
    private  String marca;

    @Basic(optional = false)
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Basic(optional = false)
    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Basic(optional = false)
    @Column(name = "preco", nullable = false)
    private Double preco;

    @Basic(optional = false)
    @Column(name = "quilometragem", nullable = false)
    private Integer quilometragem;

    @Basic(optional = false)
    @Column(name = "combustivel", nullable = false)
    private String combustivel;

    @Basic(optional = false)
    @Column(name = "transmissao", nullable = false)
    private String transmissao;

    @Basic(optional = false)
    @Column(name = "cor", nullable = false)
    private String cor;

    @Basic(optional = false)
    @Column(name = "forca", nullable = false)
    private Integer forca;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private String status;

    @Basic(optional = false)
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Basic(optional = false)
    @Column(name = "datacriacao", nullable = false)
    private Date dataCriacao;

    @Basic(optional = true)
    @Column(name = "dataatualizacao")
    private Date dataAtualizacao;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    public Carro(String marca, String modelo, Integer ano, Double preco, Integer quilometragem, String combustivel,
            String transmissao, String cor, Integer forca, String status, String descricao, Date dataCriacao,
            Date dataAtualizacao, Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.combustivel = combustivel;
        this.transmissao = transmissao;
        this.cor = cor;
        this.forca = forca;
        this.status = status;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
    }
}
