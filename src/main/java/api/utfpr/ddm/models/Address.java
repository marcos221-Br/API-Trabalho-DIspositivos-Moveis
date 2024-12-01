package api.utfpr.ddm.models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Address implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "cep", nullable = false)
    private String cep;

    @Basic(optional = false)
    @Column(name = "road", nullable = false)
    private String road;

    @Basic(optional = false)
    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private String state;

    @Basic(optional = false)
    @Column(name = "country", nullable = false)
    private String country;

    @Basic(optional = false)
    @Column(name = "complement")
    private String complement;

    public Address(String cep, String road, String neighborhood, String state, String country, String complement) {
        this.cep = cep;
        this.road = road;
        this.neighborhood = neighborhood;
        this.state = state;
        this.country = country;
        this.complement = complement;
    }
}
