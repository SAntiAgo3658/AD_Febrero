package edu.cesur;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.SystemException;

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
    private Date[] visitas;
    private final static int MAX_VISITAS = 5;

    // constructores
    public Cliente() {
        this.visitas = new Date[MAX_VISITAS];
    }

    public Cliente(String nombre, String apellido1, String apellido2, String comercialPrincipal, int idEmpresa) {

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comercialPrincipal = comercialPrincipal;
        this.idEmpresa = idEmpresa;
        this.visitas = new Date[MAX_VISITAS];
    }

    // métodos
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

    public Date[] getVisitas() {
        return visitas;
    }

    public void setVisitas(Date[] visitas) {
        this.visitas = visitas;
    }

    public static int getMaxVisitas() {
        return MAX_VISITAS;
    }

    public boolean insertarVisita(Date nuevaVisita) {
        int hueco = 0;

        while (hueco < (visitas.length)) {

            if (visitas[hueco] == null) {
                visitas[hueco] = nuevaVisita;
                ordenarVisitas();
                return true;

            }

            hueco++;

        }

        return false;

    }

    public void ordenarVisitas() {
        Date visitaPivote = new Date(2500, 01, 01);
        int i = 0;
        int j;

        while ((i < visitas.length) && (visitas[i] != null)) {
            j = 1;
            while ((j < visitas.length - i) && (visitas[j] != null)) {
                if ((visitas[j - 1].compareTo(visitas[j]) > 0)) {
                    visitaPivote = visitas[j - 1];
                    visitas[j - 1] = visitas[j];
                    visitas[j] = visitaPivote;

                }

                j++;

            }

            i++;

        }

    }

}
