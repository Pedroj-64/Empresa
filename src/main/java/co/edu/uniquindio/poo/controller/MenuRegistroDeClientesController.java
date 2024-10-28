package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;

public class MenuRegistroDeClientesController {

    // Método para registrar un cliente
    public boolean registrarCliente(String nombre, String apellido, String cedula, int edad) {
        if (validarDatos(nombre, apellido, cedula, edad)) {
            Cliente cliente = new Cliente(nombre, apellido, cedula, edad);
            // TODO: Agregar lógica para guardar el cliente (ej. en una base de datos o lista)
            System.out.println("Cliente registrado: " + cliente);
            return true;
        } else {
            System.out.println("Datos inválidos, el registro ha fallado.");
            return false;
        }
    }

    // Método para validar los datos ingresados
    private boolean validarDatos(String nombre, String apellido, String cedula, int edad) {
        return nombre != null && !nombre.isEmpty() &&
               apellido != null && !apellido.isEmpty() &&
               cedula != null && !cedula.isEmpty() &&
               edad > 0;
    }
}
