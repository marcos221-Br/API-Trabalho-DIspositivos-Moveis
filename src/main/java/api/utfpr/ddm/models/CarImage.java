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
@Table(name = "carimages")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarImage implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "car", referencedColumnName = "id", nullable = false)
    private Car car;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "image", referencedColumnName = "id", nullable = false)
    private Image image;

    public CarImage(Car car, Image image){
        this.car = car;
        this.image = image;
    }
}
