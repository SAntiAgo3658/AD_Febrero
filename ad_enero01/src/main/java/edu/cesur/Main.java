package edu.cesur;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static GestorCliente miGestorCliente;
    private static GestorPrincipal miGestorPrincipal;

    public static void main(String[] args) {
        miGestorPrincipal = new GestorPrincipal();
        miGestorPrincipal.iniciar();
        miGestorCliente = new GestorCliente();



        menuPpal();

        miGestorPrincipal.salir();

    }

    private static void menuPpal() {

        String opcion = null;
        Scanner teclado = new Scanner(System.in);

        do {
            mostrarOpcionesPpal();
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    menuCrear(teclado);
                    break;

                case "2":
                    menuLeer(teclado);
                    break;

                case "3":
                    menuActualizar(teclado);
                    break;

                case "4":
                    menuBorrar(teclado);
                    break;

                case "5":
                    menuLeerTodos();
                    break;
                default:
                    break;
            }
        } while (!opcion.equals("6"));

    }

    private static void menuCrear(Scanner teclado) {
        System.out.println("***   MENU INSERTAR CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce nombre Cliente: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce Apellido1 cliente: ");
        String apellido1 = teclado.nextLine();

        System.out.print("Introduce apellido2 cliente: ");
        String apellido2 = teclado.nextLine();

        System.out.print("Introduce comercialPrincipal cliente: ");
        String comercialPrincipal = teclado.nextLine();

        System.out.print("Introduce idEmpresa cliente: ");
        int idEmpresa = teclado.nextInt();
        teclado.nextLine();

        miGestorCliente.create(nombre, apellido1, apellido2, comercialPrincipal, idEmpresa);
        System.out.println();
    }

    private static void menuLeer(Scanner teclado) {
        System.out.println("***   MENU LEER CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Cliente a leer: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        System.out.println(miGestorCliente.read(id));
    }

    private static void menuActualizar(Scanner teclado) {
        System.out.println("***   MENU ACTUALIZAR CLIENTE   ***");
        System.out.println("--------------------------------");
        System.out.println("INTRODUCE ID DEL CLIENTE A ACTUALIZAR");
        Long id = teclado.nextLong();
        teclado.nextLine();
        Cliente miCliente = miGestorCliente.read(id);
        System.out.println("Introduce elemento a actualizar o ENTER para no actualizarlo");

        System.out.print("Introduce nombre cliente: ");
        String nombre = teclado.nextLine();
        if (!nombre.equals(""))
            miCliente.setNombre(nombre);

        System.out.print("Introduce Apellido1 cliente: ");
        String apellido1 = teclado.nextLine();
        if (!apellido1.equals(""))
            miCliente.setApellido1(apellido1);

        System.out.print("Introduce Apellido2 cliente: ");
        String apellido2 = teclado.nextLine();
        if (!apellido2.equals(""))
            miCliente.setApellido2(apellido2);

        System.out.print("Introduce comercialPrincipal cliente: ");
        String comercialPrincipal = teclado.nextLine();
        if (!comercialPrincipal.equals(""))
            miCliente.setComercialPrincipal(comercialPrincipal);

        System.out.print("Introduce idEmpresa cliente: ");
        String idEmpresa = teclado.nextLine();
        if (!idEmpresa.equals(""))
            miCliente.setIdEmpresa(Integer.parseInt(idEmpresa));

        miGestorCliente.update(miCliente.getId(), miCliente.getNombre(), miCliente.getApellido1(),
                miCliente.getApellido2(), miCliente.getComercialPrincipal(), miCliente.getIdEmpresa());
        System.out.println();

    }

    private static void menuBorrar(Scanner teclado) {
        System.out.println("***   MENU BORRAR CLIENTE   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Cliente a borrar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        miGestorCliente.delete(id);
    }

    public static void menuLeerTodos() {
        List<Cliente> listado = miGestorCliente.readAll();

        for (Cliente cliente : listado) {
            System.out.println(cliente);

        }

    }

    private static void mostrarOpcionesPpal() {
        System.out.println("***   INTRODUCE OPCION:   ***");
        System.out.println("-----------------------------");
        System.out.println("1) Introducir Cliente");
        System.out.println("2) Mostrar Cliente");
        System.out.println("3) Modificar Cliente");
        System.out.println("4) Borrar Cliente");
        System.out.println("5) Mostrar todos los Cliente");
        System.out.println("6) SALIR");
    }
}