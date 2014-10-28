package edu.ulima.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "AMIGO")
public class Amigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @OneToMany ( mappedBy = "amigo", cascade = CascadeType.PERSIST)
    private List<Compadre> compadres;

    public Amigo() {
    }

    public Amigo(int id, String nombre, List<Compadre> compadres) {
        this.id = id;
        this.nombre = nombre;
        this.compadres = compadres;
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

    public List<Compadre> getCompadres() {
        return compadres;
    }

    public void setCompadres(List<Compadre> compadres) {
        this.compadres = compadres;
    }

    @Override
    public String toString() {
        return "Amigo{" + "id=" + id + ", nombre=" + nombre + ", compadres=" + compadres + '}';
    }
    
}
