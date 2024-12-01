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
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "brand", nullable = false)
    private  String brand;

    @Basic(optional = false)
    @Column(name = "model", nullable = false)
    private String model;

    @Basic(optional = false)
    @Column(name = "year", nullable = false)
    private Integer year;

    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private Double price;

    @Basic(optional = false)
    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Basic(optional = false)
    @Column(name = "fuel", nullable = false)
    private String fuel;

    @Basic(optional = false)
    @Column(name = "transmission", nullable = false)
    private String transmission;

    @Basic(optional = false)
    @Column(name = "color", nullable = false)
    private String color;

    @Basic(optional = false)
    @Column(name = "power", nullable = false)
    private Integer power;

    @Basic(optional = false)
    @Column(name = "displacement", nullable = false)
    private Integer displacement;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private String status;

    @Basic(optional = false)
    @Column(name = "description", nullable = false)
    private String description;

    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    private Date created;

    @Basic(optional = true)
    @Column(name = "updated")
    private Date updated;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private User user;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
    private Address address;

    public Car(String brand, String model, Integer year, Double price, Integer mileage, String fuel, String transmission, String color, Integer power, Integer displacement, String status, String description, Date created, Date updated, User user, Address address){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.fuel = fuel;
        this.transmission = transmission;
        this.color = color;
        this.power = power;
        this.displacement = displacement;
        this.status = status;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.user = user;
        this.address = address;
    }
}
