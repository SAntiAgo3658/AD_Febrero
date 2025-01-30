package edu.cesur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // atributos
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String comercialPrincipal;
    private int idEmpresa;

    // constructores
    public Cliente() {
    }

    public Cliente(String nombre, String apellido1, String apellido2, String comercialPrincipal, int idEmpresa) {

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comercialPrincipal = comercialPrincipal;
        this.idEmpresa = idEmpresa;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getComercialPrincipal() {
        return comercialPrincipal;
    }

    public void setComercialPrincipal(String comercialPrincipal) {
        this.comercialPrincipal = comercialPrincipal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", comercialPrincipal=" + comercialPrincipal + ", idEmpresa=" + idEmpresa + "]";
    }

}
