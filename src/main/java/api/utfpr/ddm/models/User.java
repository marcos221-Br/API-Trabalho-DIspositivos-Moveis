package api.utfpr.ddm.models;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements UserDetails{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Basic(optional = false)
    @Column(name = "password", nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(name = "bornDate", nullable = false)
    private Date bornDate;

    @Basic(optional = false)
    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    @Basic(optional = true)
    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = true)
    private Address address;

    public User(String name, String email, String password, Date bornDate, String cellphone, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bornDate = bornDate;
        this.cellphone = cellphone;
        this.address = address;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
