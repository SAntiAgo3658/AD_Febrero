package edu.cesur;

import java.util.Arrays;
import java.util.Date;

public class MainTemp {

    public static void main(String[] args) {
        Cliente miCliente = new Cliente();

        // array vacío
        System.out.println("Antes: " +  Arrays.toString(miCliente.getVisitas()));

        miCliente.ordenarVisitas();

        System.out.println("Después: " +  Arrays.toString(miCliente.getVisitas()));

        // array con 1 elemento

        miCliente.insertarVisita(new Date("2025/01/09"));
        System.out.println("Antes: " +  Arrays.toString(miCliente.getVisitas()));

        miCliente.ordenarVisitas();

        System.out.println("Después: " +  Arrays.toString(miCliente.getVisitas()));

        // array con MAX_VISITAS -2
        miCliente.insertarVisita(new Date("2025/01/08"));
        miCliente.insertarVisita(new Date("2025/01/04"));
       

        System.out.println("Antes: " +  Arrays.toString(miCliente.getVisitas()));

        miCliente.ordenarVisitas();

        System.out.println("Después: " +  Arrays.toString(miCliente.getVisitas()));



        // array con MAX_VISITAS -1
        miCliente.insertarVisita(new Date("2025/01/06"));
        System.out.println("Antes: " +  Arrays.toString(miCliente.getVisitas()));

        miCliente.ordenarVisitas();

        System.out.println("Después: " +  Arrays.toString(miCliente.getVisitas()));


        // array lleno
        miCliente.insertarVisita(new Date("2025/01/02"));
        System.out.println("Antes: " +  Arrays.toString(miCliente.getVisitas()));

        miCliente.ordenarVisitas();

        System.out.println("Después: " +  Arrays.toString(miCliente.getVisitas()));

        
    }
    
}
