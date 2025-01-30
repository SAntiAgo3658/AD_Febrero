package edu.cesur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestorPrincipal {

    // atributos
    protected static EntityManager em;
    protected static EntityManagerFactory emf;

    // constructor
    public GestorPrincipal() {
        em = null;
    }

    // métodos
    protected void iniciar() {

        emf = Persistence.createEntityManagerFactory("clientesPU");
        em = emf.createEntityManager();

    }

    protected void salir() {

        if (em != null) {
            em.close();
        }

        if (emf != null) {
            emf.close();

        }

    }
    
}