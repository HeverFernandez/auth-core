package edu.epis.sisga.entities;

        import javax.persistence.*;
        import javax.validation.constraints.*;
        import java.io.Serializable;
        import java.util.HashSet;
        import java.util.Set;

/**
 * Created by HeverFernandez on 01/08/17.
 */

@Entity
@Table(name = "USUARIO", uniqueConstraints = {@UniqueConstraint(columnNames = { "username" })})
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    private String username;

    @Size(max = 100)
    private String password;

    @OneToOne
    @JoinColumn(name = "IDPERSONA", referencedColumnName = "IDPERSONA")
    private Persona persona;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String username, String password, Persona persona) {
        this.username = username;
        this.password = password;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", persona=" + persona +
                ", roles=" + roles +
                '}';
    }
}