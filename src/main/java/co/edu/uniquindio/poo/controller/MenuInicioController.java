package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Empresa;
/**
 * Clase Controller de la interfaz MenuInicio encargada tener logica  de negocio de la interfaz
 */
public class MenuInicioController {

    //Se instancia empresa para  poder acceder a sus metodos

    Empresa empresa;

    /**
     * metodo el cual instancia la empresa con manejo de excepciones por consola
     */
    public void instancia() {
        try {
            empresa = App.getEmpresa();
            if (empresa == null) {
                throw new IllegalStateException("La empresa no pudo ser inicializada.");
            }
            // Aunque no se use 'empresa', manejamos la posible excepción.
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
