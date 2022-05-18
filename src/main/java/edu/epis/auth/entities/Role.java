package edu.epis.sisga.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AITAMH on 18/11/2019.
 */
@Entity
@Table(name="ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrol;

    @Column(length = 60)
    private String descripcionrol;

    public Role(Long idrol) {
        this.idrol = idrol;
    }

    public Role() {
    }

    public Role(String descripcionrol) {
        this.descripcionrol = descripcionrol;
    }

    public Long getIdrol() { return idrol;  }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public String getDescripcionrol() {
        return descripcionrol;
    }

    public void setDescripcionrol(String descripcionrol) {
        this.descripcionrol = descripcionrol;
    }

}
