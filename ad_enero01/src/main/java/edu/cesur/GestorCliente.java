package edu.cesur;

import java.util.Date;
import java.util.List;

public class GestorCliente {

    // CRUD

    public void create(String nombre, String apellido1, String apellido2, String comercialPrincipal, int idEmpresa) {
        Cliente nuevoCliente = new Cliente(nombre, apellido1, apellido2, comercialPrincipal, idEmpresa);
        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.persist(nuevoCliente);
        GestorPrincipal.em.getTransaction().commit();

    }

    public Cliente read(Long id) {
        return GestorPrincipal.em.find(Cliente.class, id);

    }

    public void update(Long id, String nombre, String apellido1, String apellido2, String comercialPrincipal,
            Integer idEmpresa, Date nuevaVisita) {
        Cliente miCliente = GestorPrincipal.em.find(Cliente.class, id);
        if (nombre != null)
            miCliente.setNombre(nombre);
        if (apellido1 != null)
            miCliente.setApellido1(apellido1);
        if (apellido2 != null)
            miCliente.setApellido2(apellido2);
        if (comercialPrincipal != null)
            miCliente.setComercialPrincipal(comercialPrincipal);
        if (idEmpresa != null)
            miCliente.setIdEmpresa(idEmpresa);
        if (nuevaVisita != null)
            miCliente.insertarVisita(nuevaVisita);

        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.merge(miCliente);
        GestorPrincipal.em.getTransaction().commit();

    }

    public void delete(Long id) {

        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.remove(GestorPrincipal.em.find(Cliente.class, id));
        GestorPrincipal.em.getTransaction().commit();

    }

    public List<Cliente> readAll() {

        GestorPrincipal.em.getTransaction().begin();

        List<Cliente> clientes = GestorPrincipal.em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();

        GestorPrincipal.em.getTransaction().commit();
        return clientes;

    }

}
