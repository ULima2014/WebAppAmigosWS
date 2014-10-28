package edu.ulima.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "Compadre")
public class Compadre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn (name = "AMIGO_ID")
    private Amigo amigo;

    public Compadre() {
    }

    public Compadre(int id, String nombre, Amigo amigo) {
        this.id = id;
        this.nombre = nombre;
        this.amigo = amigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    @Override
    public String toString() {
        return "Compadre{" + "id=" + id + ", nombre=" + nombre + ", amigo=" + amigo + '}';
    }
    
    
    
    
}
