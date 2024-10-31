package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;

/**
 * Clase Controller de la interfaz de su mismo nombre encarga de la conexion con
 * la logica de negocio a la
 * hora de registrar un nuevo cliente.
 * 
 */
public class MenuRegistroDeClientesController {

    Empresa empresa;

    /**
     * metodo Instancia para conectar la instancia con la empresa ya instanciada
     */
    public void instancia() {
        empresa = App.getEmpresa();
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula.");
        }
    }

    /**
     * Metodo que recibe datos y regitra cliente valiendose de logica del modelo
     * 
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    public boolean registrarCliente(String nombre, String apellido, String cedula, int edad) {
        boolean banderilla = true;
        try {
            if (empresa == null) {
                throw new IllegalStateException("La empresa no está inicializada.");
            }
            if (validarDatos(nombre, apellido, cedula, edad)) {
                Cliente cliente = new Cliente(nombre, apellido, cedula, edad);
                empresa.agregarCliente(cliente);
                System.out.println("Cliente registrado: " + cliente);
                banderilla = true;
            } else {
                System.out.println("Datos inválidos, el registro ha fallado.");
                banderilla = false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
            banderilla = false;
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            banderilla = false;
        }
        return banderilla;
    }

    /**
     * Metodo auxiliar del metodo agregar clientes el cual valida que los campos
     * esten llenados correctamente
     * 
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    private boolean validarDatos(String nombre, String apellido, String cedula, int edad) {
        boolean banderilla = true;

        if (nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                cedula == null || cedula.isEmpty() ||
                edad <= 0) {
            throw new IllegalArgumentException("Los datos del cliente no pueden ser nulos o inválidos.");
        }
        return banderilla;
    }
}
